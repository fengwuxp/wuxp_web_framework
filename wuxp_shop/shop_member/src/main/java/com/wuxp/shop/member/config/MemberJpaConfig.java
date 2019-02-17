package com.wuxp.shop.member.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;


/**
 * jpa bean配置
 *
 * @author wxup
 * @create 2018-06-16 11:21
 **/
@Configuration
//@Profile("local")
//@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
//        "com.wuxp.shop.system.repositories",
        "com.wuxp.basic.member.repositories"
})
@EntityScan(basePackages = {
        "com.wuxp.basic.member.entities",
        "com.wuxp.basic.system.entities"
})
public class MemberJpaConfig {

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
}
