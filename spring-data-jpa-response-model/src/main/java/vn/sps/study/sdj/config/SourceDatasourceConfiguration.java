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
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import vn.sps.study.sdj.jpa.src.entity.SrcProcessEventEntity;
import vn.sps.study.sdj.jpa.src.repository.SrcProcessEventRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = SrcProcessEventRepository.class, entityManagerFactoryRef = "sourceEntityManagerFactory", transactionManagerRef = "sourceTransactionManager")
public class SourceDatasourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.source")
    DataSource sourceProcessEventDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean sourceEntityManagerFactory(
        EntityManagerFactoryBuilder builder) {
        return builder.dataSource(sourceProcessEventDataSource())
            .packages(SrcProcessEventEntity.class).build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager sourceTransactionManager(
        @Qualifier("sourceEntityManagerFactory") final LocalContainerEntityManagerFactoryBean sourceEntityManagerFactory) {
        return new JpaTransactionManager(
            sourceEntityManagerFactory.getObject());
    }
}
