#### 文章基于spring boot 2.x

#### spring cloud 服务治理

#### spring cloud使用 eureka来治理服务，所有的服务都需要注册到eureka服务注册中心上

##### 参考文章[https://blog.csdn.net/sunhuiliang85/article/details/76222517]

---------------------

##### eureka server(Eureka服务端，服务注册中心)

* Eureka服务端，即服务注册中心。它同其他服务注册中心一样，支持高可用配置。依托于强一致性提供良好的服务实例可用性，可以应对多种不同的故障场景。
* Eureka服务端支持集群模式部署，当集群中有分片发生故障的时候，Eureka会自动转入自我保护模式。它允许在分片发生故障的时候继续提供服务的发现和注册，
* 当故障分配恢复时，集群中的其他分片会把他们的状态再次同步回来。集群中的的不同服务注册中心通过异步模式互相复制各自的状态，这也意味着在给定的时间
* 点每个实例关于所有服务的状态可能存在不一致的现象。

###### 基本使用

      1: 添加依赖
      
          <dependency>
               <groupId>org.springframework.cloud</groupId>
               <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
          <version>${spring.cloud.version}</version>
          
      2: 在启动类上加上注解: @EnableEurekaServer   

##### 配置相关
* eureka.instance.prefer-ip-address [http://www.itmuch.com/spring-cloud-code-read/spring-cloud-code-read-eureka-registry-ip/]

-------------------------------

##### eureka client( Eureka客户端)       

*Eureka客户端，主要处理服务的注册和发现。客户端服务通过注册和参数配置的方式，嵌入在客户端应用程序的代码中。在应用程序启动时，
*Eureka客户端向服务注册中心注册自身提供的服务，并周期性的发送心跳来更新它的服务租约。同时，他也能从服务端查询当前注册的服务信息并把它们缓存到本地并周期行的刷新服务状态。

-------------------------------
#### 常见问题

1. Eureka 之集群同步，自我保护模式以及实例注册、心跳、下线 参考文章 [https://blog.csdn.net/hry2015/article/details/78245149] [https://blog.csdn.net/rickiyeat/article/details/71041648]
2. 服务监控(spring-boot-starter-actuator) 参考文章[https://www.jianshu.com/p/481134c3fab7] [https://www.cnblogs.com/EasonJim/p/7613333.html]

--------------------------------

##### 服务分为提供者（provider），和消费者(consumer)，都需要注册到服务注册中(eureka)

###### 基本使用

            1：添加依赖
            
               <dependency>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-starter-eureka</artifactId>
                    <version>${spring.cloud.eureka.version}</version>
               </dependency>           

            2：在启动类上加上注解: @EnableDiscoveryClient，表示是一个服务,注册到服务中心上
            
            3：application.yml中配置：
               
               eureka:
                 client:
                   service-url:
                     ##单点配置:
               #      defaultZone: http://eureka1:8001/eureka/
                     ##高可用配置
                     defaultZone: http://eureka1:8761/eureka/,http://eureka2:8762/eureka/



---------------------------
