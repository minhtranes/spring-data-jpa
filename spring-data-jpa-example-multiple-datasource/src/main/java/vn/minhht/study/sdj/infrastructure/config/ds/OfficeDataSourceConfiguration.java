/*
 * Class: ProjectOneDatasource
 *
 * Created on Apr 6, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.minhht.study.sdj.infrastructure.config.ds;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.DataSourceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import vn.minhht.study.sdj.infrastructure.persistence.entity.office.Device;
import vn.minhht.study.sdj.infrastructure.persistence.repository.office.DeviceRepository;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "officeEntityManagerFactory", transactionManagerRef = "officeTransactionManager", basePackageClasses = {
    DeviceRepository.class })
public class OfficeDataSourceConfiguration {

    private static final Logger LOGGER = LoggerFactory
        .getLogger(OfficeDataSourceConfiguration.class);

    @Bean(name = "officeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
        final EntityManagerFactoryBuilder builder,
        @Qualifier("officeDataSource") final DataSource dataSource) {
        return builder.dataSource(dataSource).packages(Device.class)
            .persistenceUnit("office").build();
    }

    @Bean(name = "officeDataSource")
    @ConfigurationProperties(prefix = "datasource.office")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "officeTransactionManager")
    public PlatformTransactionManager transactionManager(
        @Qualifier("officeEntityManagerFactory") final EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    @ConditionalOnProperty(prefix = "datasource.office", name = "jmx-enabled", havingValue = "true", matchIfMissing = true)
    public Object officeDataSourceMBean(
        @Qualifier("officeDataSource") DataSource dataSource) {
        if (dataSource instanceof DataSourceProxy) {
            try {
                return ((DataSourceProxy) dataSource).createPool()
                    .getJmxPool();
            }
            catch (SQLException ex) {
                LOGGER.warn(
                    "Failed to register connection pool writerDataSource to JMX server !",
                    ex);
            }
        }
        else {
            LOGGER.warn(
                "Not supported registering JMX for type: {}",
                dataSource.getClass().getName());
        }

        return null;
    }
}