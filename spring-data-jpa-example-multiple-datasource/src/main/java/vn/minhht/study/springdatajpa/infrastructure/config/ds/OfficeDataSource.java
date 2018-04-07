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
package vn.minhht.study.springdatajpa.infrastructure.config.ds;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
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

import vn.minhht.study.springdatajpa.infrastructure.persistence.entity.office.Device;
import vn.minhht.study.springdatajpa.infrastructure.persistence.repository.office.DeviceRepository;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "officeEntityManagerFactory", transactionManagerRef = "officeTransactionManager", basePackageClasses = {
    DeviceRepository.class })
public class OfficeDataSource {

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
}