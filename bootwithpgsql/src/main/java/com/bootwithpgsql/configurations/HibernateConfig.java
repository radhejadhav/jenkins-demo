package com.bootwithpgsql.configurations;

import com.bootwithpgsql.entities.Demo1;
import com.bootwithpgsql.services.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@Transactional
@EnableTransactionManagement
public class HibernateConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:postgresql://localhost:5432/mydb");
        ds.setUsername("postgres");
        ds.setPassword("root");
        ds.setDriverClassName("org.postgresql.Driver");

        return ds;
    }

    public Properties hibernateProperties(){
        Properties properties = new Properties();

        properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQL9Dialect");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.hbm2ddl.auto","update");

        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(dataSource());
        sf.setHibernateProperties(hibernateProperties());
        sf.setPackagesToScan("com.bootwithpgsql");

        return sf;
    }

    @Bean
    public TransactionManager transactionManager(){
        HibernateTransactionManager tm = new HibernateTransactionManager();
        tm.setSessionFactory(sessionFactory().getObject());
        return tm;
    }

//    @Bean
////    @Scope("prototype")
//    public StudentService getStudentService(Demo1 demo1){
//        return new StudentService(demo1);
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Demo1 getDemo1(){
//        return new Demo1();
//    }
}
