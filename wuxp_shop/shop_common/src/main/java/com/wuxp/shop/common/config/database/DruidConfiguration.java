package com.wuxp.shop.common.config.database;

/**
 * ali druid数据库连接池配置
 *
 * @author wxup
 * @create 2018-06-16 22:25
 **/
public class DruidConfiguration {


//    @Bean
//    public ServletRegistrationBean<StatViewServlet> statViewServlet(){
//        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
//        //白名单
//        servletRegistrationBean.addInitParameter("allow","127.0.01");
//        //IP黑名单（共同存在时，deny优先于allow）
//        servletRegistrationBean.addInitParameter("deny","192.168.1.100");
//        //登陆查看新的是账户密码
//        servletRegistrationBean.addInitParameter("loginUsername","druid");
//        servletRegistrationBean.addInitParameter("loginPassword","123456");
//        //是否能够重置数据
//        servletRegistrationBean.addInitParameter("resetEnable","false");
//        return servletRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean<WebStatFilter> statFilter(){
//        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(new WebStatFilter());
//        //添加过滤规则
//        filterRegistrationBean.addUrlPatterns("/*");
//        //添加不需要忽略的格式信息
//        filterRegistrationBean.addInitParameter("exclusions","*.js.*.gif,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
}
