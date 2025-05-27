package com.database_replica.copy_of_database.mysql.config;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.database_replica.copy_of_database.mysql.repo",
        entityManagerFactoryRef = "entityManagerFactoryBean",
        transactionManagerRef = "transactionManager"
)
public class MySqlDbConfig {

    @Autowired
    private Environment environment;

    @Bean(name= "dataSourse")
    @Primary
    public DataSource dataSource()
    {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));

        return dataSource;
    }


@Bean(name = "entityManagerFactoryBean")
@Primary
public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
{
    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

    factoryBean.setDataSource(dataSource());

    factoryBean.setPackagesToScan("com.database_replica.copy_of_database.mysql.entity");

    JpaVendorAdapter vendorAdapter =  new HibernateJpaVendorAdapter();

    factoryBean.setJpaVendorAdapter(vendorAdapter);

    //

    Map<String, String>  props = new HashMap<>();
    props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    props.put("hibernate.show_sql","true");
    props.put("hibernate.format_sql","true");
    props.put("hibernate.hbm2ddl.auto","update");


    factoryBean.setJpaPropertyMap(props);
    return  factoryBean;

}

@Primary
@Bean(name = "transactionManager")
public PlatformTransactionManager transactionManager() {

    JpaTransactionManager transactionManager = new JpaTransactionManager();

    transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());

    return transactionManager;
}

}