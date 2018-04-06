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

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectOneDatasource {

    @Bean
    @ConfigurationProperties(prefix = "datasource.ds1")
    DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }
    
    DataSource datasource() {
        return 
    }
}
