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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import vn.minhht.study.springdatajpa.infrastructure.persistence.entity.people.Department;
import vn.minhht.study.springdatajpa.infrastructure.persistence.repository.people.DepartmentRepository;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "peopleEntityManagerFactory", transactionManagerRef = "peopleTransactionManager", basePackageClasses = {
    DepartmentRepository.class })
public class PeopleDataSourceConfiguration {

    @Primary
    @Bean(name = "peopleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
        final EntityManagerFactoryBuilder builder,
        @Qualifier("peopleDataSource") final DataSource dataSource) {
        return builder.dataSource(dataSource).packages(Department.class)
            .persistenceUnit("people").build();
    }

    @Primary
    @Bean(name = "peopleDataSource")
    @ConfigurationProperties(prefix = "datasource.people")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "peopleTransactionManager")
    public PlatformTransactionManager peopleTransactionManager(
        @Qualifier("peopleEntityManagerFactory") final EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}