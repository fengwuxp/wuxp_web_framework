package com.wuxp.shop.member.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


/**
 * jpa bean配置
 *
 * @author wxup
 * @create 2018-06-16 11:21
 **/
@Configuration
//@Profile("local")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.wuxp.shop.member.repository"})
public class JpaConfig implements EnvironmentAware {


    private static final Logger logger = LoggerFactory.getLogger(JpaConfig.class);

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    Properties jpaProperties() {
        return new Properties() {
            {
//                setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
                //allows Hibernate to generate SQL optimized for a particular relational database.
                setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
                setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
            }
        };
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
        logger.info("初始化ali druid数据库连接池");
        return dataSource;
    }


//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        //此处com.example.*.model是你的java bean所在的包名
//        factory.setPackagesToScan("com.example.*.model");
//        factory.setDataSource(dataSource());
//
//        Map<String, Object> jpaProperties = new HashMap<String, Object>();
//        jpaProperties.put("hibernate.ejb.naming_strategy","org.hibernate.cfg.ImprovedNamingStrategy");
//        jpaProperties.put("hibernate.jdbc.batch_size",50);
//
//        factory.setJpaPropertyMap(jpaProperties);
//        factory.afterPropertiesSet();
//        return factory.getObject();
//    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaProperties(jpaProperties());
        factory.setPackagesToScan(
                "com.wuxp.shop.member.entities",
                "com.wuxp.shop.system.entities"
        );

        //factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        EntityManagerFactory factory = entityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }


}
