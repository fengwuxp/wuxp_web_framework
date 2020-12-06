
##### 过滤器链 （filter chain）
- DelegatingFilterProxy 
```
   1：spring security的filter入口，本身对做请求做任何处理，主要是从spring的上下文中找到一个委托（代理）的filter
   2：该类默认被配置在SecurityFilterAutoConfiguration中，如果想自定义一个Bean用于替换该类的实现，
可以自定义一个名称为springSecurityFilterChain的bean
```
- FilterChainProxy    
```
  spring security的内部构件的一个过滤器链，用于执行所有的配置的spring security相关的bean，通过SecurityFilterChain#matches(HttpServletRequest request)对请求（url,请求方法等）
 做匹配得到需要执行的过滤器列表，并逐个执行，
```
- FilterSecurityInterceptor
```
  最终处理请求的授权（登录和访问控制，登录也是访问控制的一种）判断，判定无权限将会抛出认证相关异常
```
- ExceptionTranslationFilter
```
   该ExceptionTranslationFilter在FilterSecurityInterceptor安全过滤器堆栈的上面。它没有做任何实际的安全执法本身，而是处理由安全拦截器抛出的异常，并提供合适的HTTP响应
   
  AuthenticationEntryPoint
   如果用户请求一个安全HTTP资源这个AuthenticationEntryPoint将被调用，但他们不被认证。适当的AuthenticationException或AccessDeniedException将被安全拦截器进一步拆毁了调用堆栈，
   触发入口点的commence方法。这确实呈现给用户的适当的反应，使认证可以开始工作。我们这里使用的是LoginUrlAuthenticationEntryPoint，这将请求重定向到一个不同的URL（一般是一个登录页面）。
   使用将取决于你想要的认证机制的实际实现在应用程序中使用。
```
- [SecurityContextPersistenceFilter](https://www.springcloud.cc/spring-security-zhcn.html#security-context-persistence-filter)
```
   1：用于从请求信息中（cookie,token），通过SecurityContextRepository，交换到SecurityContext，并设置到SecurityContextHolder中
   ，请求完成后会清除SecurityContextHolder的SecurityContext，默认实现为，HttpSessionSecurityContextRepository
   2：可以使用HttpSecurity#securityContext方法返回的SecurityContextConfigurer替换SecurityContextRepository的实现
```  
- [UsernamePasswordAuthenticationFilter](https://www.springcloud.cc/spring-security-zhcn.html#form-login-filter)


##### SecurityContextHolder
- SecurityContext的持有者，默认使用的ThreadLocal的方式实现
- 替换SecurityContextHolderStrategy策略
```
  SecurityContextHolder通过系统变量 spring.security.strategy获取需要使用的SecurityContextHolderStrategy策略的名称，默认
  值为：MODE_THREADLOCAL，如果是自定义的策略需要配置自定义策略类的全类名
```

#### HttpSecurity
```
  1：它允许为特定的http请求配置基于web的安全性，例如：登录方式、会话管理、cros、crsf、url权限等等
  2：可以配置多个HttpSecurity，通过Orderd和路径匹配来区分优先级和处理的路径
```

##### 认证提供者和认证管理器
- Authentication
```
  表示身份验证请求或已验证主体的令牌，用来记录用户信息和相关权限信息
```
- 认证管理器
```
    管理配置认证提供者，通过AuthenticationProvider#supports匹配对应的AuthenticationProvider
```
- 认证提供者
```
  登录认证的提供者，用于实现某种登录方式的细节 
```
- AbstractAuthenticationProcessingFilter
```
   1：基于浏览器的基于HTTP的身份验证请求的抽象处理器，需要设置认证管理器，认证路径的匹配方式（基于url或RequestMatcher）,并且负责处理登录成功或失败的处理。
   2：子类需要实现实际身份验证过程，生成登录认证的token并调用认证管理器
```

##### 访问决策管理器和访问决策投票者



#### 认证异常
- 



##### 踩坑记录
- 配置忽略登录的路径不生效

