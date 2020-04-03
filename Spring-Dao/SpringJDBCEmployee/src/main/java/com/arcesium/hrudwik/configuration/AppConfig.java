package com.arcesium.hrudwik.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@ComponentScan(basePackages = "com.arcesium.hrudwik")
@PropertySource("classpath:database.properties")
public class AppConfig {

    public DataSource driverManagerDataSource(String url, String username
            , String password , String driceClassName) {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(url, username, password);
        driverManagerDataSource.setDriverClassName(driceClassName);
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate (@Value("${jdbc.url:myurl}") String url,
                                      @Value("${jdbc.username:myUser}") String username
            , @Value("${jdbc.password:myPassword}") String password
            , @Value("${jdbc.driver:name}") String driceClassName) {
         JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource(url, username, password, driceClassName));
         jdbcTemplate.setDataSource(driverManagerDataSource(url, username, password, driceClassName));

         return  jdbcTemplate;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer () {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
