package com.foo.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.IOException;
import java.io.Reader;

@Configuration
@ComponentScan(basePackages = "com.foo")
@PropertySource("classpath:database.properties")
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public SqlSession sqlSession(@Value("${mybatis.configuration}") String myBatisConfigXMLLocation) {
        try {
            Reader reader = Resources.getResourceAsReader(myBatisConfigXMLLocation);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();

            return session;
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Couldn't able to read mybatis configuration");
        }
        return null;
    }

    /*@Bean
    public SqlSession sqlSession(@Value("${driver}") String driver, @Value("${url}") String url,
                                 @Value("${dbuser}") String userName, @Value("${dbpassword}") String password,
                                 @Value("${mybatis.mapper-locations}") String mapperLocation){

        DataSource dataSource = new PooledDataSource(driver, url, userName,password);

        Environment environment = new Environment("Development", new JdbcTransactionFactory(), dataSource);

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setEnvironment(environment);
        configuration.addMappers(mapperLocation);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        try {
            SqlSession session = sessionFactory.openSession();
            return session;
        } catch (Exception e){
            e.printStackTrace();
            //e.getMessage();
        }

        return null;
    }*/

    /*@Bean(name = "postgresDatasource")
    public DataSource dataSource(String driver, String url, String userName, String password) {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driver);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(userName);
        driverManagerDataSource.setPassword(password);

        return driverManagerDataSource;
    }*/
}
