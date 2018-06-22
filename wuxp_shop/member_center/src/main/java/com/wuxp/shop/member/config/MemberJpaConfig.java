package com.wuxp.shop.member.config;

import com.wuxp.shop.common.config.database.JpaConfig;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


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
public class MemberJpaConfig extends JpaConfig {


}
