/*
 * Class: AppConfiguration
 *
 * Created on Oct 22, 2020
 *
 * (c) Copyright Swiss Post Solutions Ltd, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.sps.study.sdj.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import vn.sps.study.sdj.jpa.des.entity.DesProcessEventEntity;
import vn.sps.study.sdj.jpa.des.repository.DesProcessEventRepository;

@Profile("des")
@Configuration
@EnableJpaRepositories(basePackageClasses = DesProcessEventRepository.class, entityManagerFactoryRef = "destinationEntityManagerFactory", transactionManagerRef = "destinationTransactionManager")
public class DestinationDatasourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.destination")
    DataSourceProperties desDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    DataSource desProcessEventDataSource() {
        return desDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    LocalContainerEntityManagerFactoryBean destinationEntityManagerFactory(
        EntityManagerFactoryBuilder builder) {
        return builder.dataSource(desProcessEventDataSource())
            .persistenceUnit("des").packages(DesProcessEventEntity.class)
            .build();
    }

    @Bean
    public PlatformTransactionManager destinationTransactionManager(
        @Qualifier("destinationEntityManagerFactory") final LocalContainerEntityManagerFactoryBean destinationEntityManagerFactory) {
        return new JpaTransactionManager(
            destinationEntityManagerFactory.getObject());
    }
}
