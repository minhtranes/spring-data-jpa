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

import vn.minhht.study.springdatajpa.infrastructure.persistence.entity.hr.Department;
import vn.minhht.study.springdatajpa.infrastructure.persistence.repository.hr.DepartmentRepository;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "ds1EntityManagerFactory", 
transactionManagerRef = "ds1TransactionManager", 
basePackageClasses = {
    DepartmentRepository.class })
public class ProjectOneDataSource {

    @Primary
    @Bean(name = "ds1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(
        final EntityManagerFactoryBuilder builder,
        @Qualifier("ds1DataSource") final DataSource dataSource) {
        return builder.dataSource(dataSource).packages(Department.class)
            .persistenceUnit("ds1").build();
    }

    @Primary
    @Bean(name = "ds1DataSource")
    @ConfigurationProperties(prefix = "datasource.ds1")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "ds1TransactionManager")
    public PlatformTransactionManager ds1TransactionManager(
        @Qualifier("ds1EntityManagerFactory") final EntityManagerFactory barEntityManagerFactory) {
        return new JpaTransactionManager(barEntityManagerFactory);
    }
}