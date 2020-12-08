
##### spring security 相关资料
- [中文参考手册](https://www.springcloud.cc/spring-security-zhcn.html)
- [Spring Security 实战干货](https://felord.cn/categories/spring-security/)

#### 登录相关的基础配置
- formLogin
```
  // 配置一个表单登录
  http.formLogin()  
       // 自定义登录页面路径，不配置则使用默认登录页面  
      .loginPage("")
       // 自定义登录处理路径
      .loginProcessingUrl("")
       // 登录成功的处理
      .successHandler(null)
       // 登录失败处理
      .failureHandler(null)
       // 登录成功后的跳转路径 一般和successHandler 分开是使用
      .successForwardUrl("")
       // 登录失败后的跳转路径 一般和failureHandler 分开是使用
      .failureForwardUrl("")
       // 以上配置表单登录的所有相关路径不需要登录
      .permitAll()                            

  1：DefaultLoginPageGeneratingFilter 用于返回默认的登陆页面，如果自定义类登陆页面，这个filter不会加入过滤器链中
  2：UsernamePasswordAuthenticationFilter 用于处理表单登录或者是其他方式的用户密码登录
```
- cookie、session管理
```
// 配置会话管理
http.sessionManagement()
     // 会话失效时的处理策略
    .invalidSessionStrategy()
    // 会话失效时的跳转url
    .invalidSessionUrl()
    // spring security的会话的创建策略 总是创建\不创建但是会使用存在的\如果需要则创建\不创建也不使用
    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    // 同一个用户可以拥有的最大允许会话数 {@link ConcurrentSessionControlAuthenticationStrategy}
    .maximumSessions(wuxpAuthenticateProperties.getMaximumSessions())
     // 会话过期的处理策略
    .expiredSessionStrategy(this.sessionInformationExpiredStrategy);
```

- 退出
```
  http.logout()
      // 退出的处理路径 默认 /logout
      .logoutUrl()
      // 添加退出处理器，允许添加多个
      .addLogoutHandler()
      // 退出后需要删除的cookie，通过设置cookie的maxAge=0实现
      .deleteCookies()
      // 退出是是否将Session失效掉
      .invalidateHttpSession(true)
      // 退出登录成功的处理者
      .logoutSuccessHandler()
       // 退出登录成功后跳转的url，默认/login?logout
      .logoutSuccessUrl()
       // 以上配置退出登录的所有相关路径不需要登录
      .permitAll()
```

- 配置不需要登录的路径
```
    // 方式1
    web.ignoring().antMatchers(
                   "/error",
                   "/upload/**",
                   "/js/**",
                   "/css/**",
                   "/images/**",
                   "/v3/api-docs/**",
                   "/swagger-ui/**",
                   "/swagger-ui.html",
                   "/webjars/**",   
           );

   //  方式2
   http.authorizeRequests()
        .antMatchers(
            "/login",
            "/api/mock/**"
        )
        .permitAll()

   两种方式的区别是：
     第一种不会进入spring security的相关filter，
     第二种会将配置的忽略的路径统一转换为spel表达，设置到FilterSecurityInterceptor中，在处理认证或访问控制的的时候进行忽略
   
```
- 匿名用户和rememberMe
- 异常处理
```
  http.exceptionHandling()
        // 访问权限操作的资源处理
       .accessDeniedHandler(this.accessDeniedHandler())
        // 鉴权异常处理，未登录或无权限  ExceptionTranslationFilter、FilterSecurityInterceptor
       .authenticationEntryPoint(this.authenticationEntryPoint())   
                  
```
- cors（跨域资源访问）支持
- csrf（跨站伪造攻击）防护支持
- [认证管理器和认证提供者](https://www.springcloud.cc/spring-security-zhcn.html#core-services-authentication-manager)
- [UserDetailsService](https://www.springcloud.cc/spring-security-zhcn.html#trueuserdetailsservice)
- [Password Encoding](https://www.springcloud.cc/spring-security-zhcn.html#core-services-password-encoding)
```
  spring security 提供给多种密码Encoding的实现
```

#### 自定义一种登录方式
- 实现一个AbstractAuthenticationProcessingFilter的子类用于匹配处理登录的请求
- 实现一个AuthenticationProvider用于处理登录的细节
- 实现一个Authentication的子类用于传递登录相关的数据
- 实现AuthenticationFailureHandler、AuthenticationFailureHandler 用于处理登录成功和失败的后续处理
- 实现SecurityConfigurerAdapter 用于将以上自定义的实现配置到spring security中

#### 访问控制，权限
- url权限、方法权限
- 数据权限（acl access control layer）
