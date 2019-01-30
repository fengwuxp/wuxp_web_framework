####  spring boot profile配置  

##### 核心思路是同过配置maven的profile变量，在使用maven-resources-plugin插件根据当前激活的profile 吧resources下对应目录的配置文件拷贝到classpath目录下

##### 参考文章 [Spring Boot Profile 与Maven Profile](http://tramp.cincout.cn/2017/07/04/tool-2017-07-05-integrate-maven-profile-with-spring-boot-profile)

#####  maven-resources-plugin:
        maven-resources-plugin 用来处理资源文件
        默认的主资源文件目录是src/main/resources，很多用户会需要添加额外的资源文件目录，这个时候就可以通过配置maven-resources-plugin来实现。
        此外，资源文件过滤也是Maven的一大特性，你可以在资源文件中使用${propertyName}形式的Maven属性，然后配置maven-resources-plugin开启对资源文件的过滤，
        之后就可以针对不同环境通过命令行或者Profile传入属性的值，以实现更为灵活的构建。

#####  参考文章
- [maven插件maven-resources-plugin的使用](https://blog.csdn.net/u014515854/article/details/79166061)
- [maven-resource-plugin的使用](https://blog.csdn.net/ouyang111222/article/details/78788106)

          
           
          
