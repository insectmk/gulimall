# 谷粒商城

基于[Java项目《谷粒商城》架构师级Java项目实战，对标阿里P6-P7，全网最强](https://www.bilibili.com/video/BV1np4y1C7Yf)教学视频的实现代码。

## 软件版本

1. JDK（`1.8`）：
2. MYSQL（`5.7`）：
3. Redis（`7.2`）：

## 项目技术

1. Maven（`3.6.3`）：

2. Spring-Boot（`2.3.3.RELEASE`）：

3. Spring-Cloud（`Hoxton.SR7`）：

4. [Spring-Cloud-Alibaba](https://github.com/alibaba/spring-cloud-alibaba/blob/greenwich/README-zh.md)（`2.1.0.RELEASE`）：

   使用组件：

   1. [Nacos](https://github.com/alibaba/Nacos)（`1.1.3`）：（[注册中心](https://github.com/alibaba/spring-cloud-alibaba/blob/greenwich/spring-cloud-alibaba-examples/nacos-example/nacos-discovery-example/readme-zh.md)与[配置中心](https://github.com/alibaba/spring-cloud-alibaba/blob/greenwich/spring-cloud-alibaba-examples/nacos-example/nacos-config-example/readme-zh.md)）一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。

      [Nacos使用案例](https://github.com/alibaba/spring-cloud-alibaba/blob/2023.x/spring-cloud-alibaba-examples/nacos-example/readme-zh.md)

   2. [Alibaba Cloud OSS](https://github.com/alibaba/aliyun-spring-boot/blob/master/aliyun-spring-boot-samples/aliyun-oss-spring-boot-sample/README-zh.md)：对象存储服务

   2. [Sentinel](https://github.com/alibaba/Sentinel)：把流量作为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性。

   3. [Seata](https://github.com/seata/seata)：阿里巴巴开源产品，一个易于使用的高性能微服务分布式事务解决方案。

5. Spring-Cloud-Ribbon：负载均衡

6. Spring-Cloud-Feign：声明式HTTP客户端（调用远程服务）

7. Spring-Cloud-Geteway：网关

8. Spring-Cloud-Sleuth：调用链监控

## 快速构建管理系统

[人人开源/renren-fast-vue](https://gitee.com/renrenio/renren-fast-vue)

[人人开源/renren-fast](https://gitee.com/renrenio/renren-fast)

[人人开源/renren-generator](https://gitee.com/renrenio/renren-generator)

## 遇到的问题

1. 使用VirtualBox遇到问题不知道怎么解决，改为使用VM ware。

2. 导入人人开源管理后台时，提示父类模块不正确。
   在子模块的`<parent>`标签下增加`<relativePath/>`即可。

3. [谷粒商城 p16 node-sass报错最简单解决方法](https://gitee.com/renrenio/renren-fast-vue/issues/I900BR)

4. p17，common模块导入人人开源类的时候，需要自己解决类问题（**下一P老师会解决**），可以参考以下maven坐标：
   ```xml
   <!-- https://mvnrepository.com/artifact/javax.validation/validation-api -->
   <dependency>
       <groupId>javax.validation</groupId>
       <artifactId>validation-api</artifactId>
       <version>2.0.1.Final</version>
   </dependency>
   
   <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
   <dependency>
       <groupId>javax.servlet</groupId>
       <artifactId>javax.servlet-api</artifactId>
       <version>4.0.1</version>
       <scope>provided</scope>
   </dependency>
   
   <dependency><!-- 人人开源的包 -->
       <groupId>commons-lang</groupId>
       <artifactId>commons-lang</artifactId>
       <version>2.6</version>
   </dependency>
   ```

5. Spring-Cloud-Alibaba版本问题，需要处理好。

6. EasyConnect软件会占用10000端口。

7. p46，将人人开源后端注册到nacos出现问题。

   1. 将人人开源`pom.xml`的springboot版本切换为`2.3.3.RELEASE`。
   2. 按照p47的说明，修改`io.renren.config.CorsConfig.java`，将跨域配置注释掉就行了。

8. p62，maven坐标`aliyun-oss-spring-boot-starter`引入失败问题，参考[阿里云OSS对象存储依赖引入失败 怎么解决](https://github.com/alibaba/aliyun-spring-boot/issues/40#top)，个人实测只需要加上版本号就行了。

   ```maven
   <dependency>
       <groupId>com.alibaba.cloud</groupId>
       <artifactId>aliyun-oss-spring-boot-starter</artifactId>
       <version>1.0.0</version>
   </dependency>
   ```

9. p66，没有`org.hibernate.validator.constraints.URL`需要在`gulimall-common`中导包，坐标如下：

   ```xml
   <!-- https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator -->
   <dependency>
       <groupId>org.hibernate.validator</groupId>
       <artifactId>hibernate-validator</artifactId>
       <version>6.2.0.Final</version>
   </dependency>
   ```

10. 如果git仓库是公开的，不要把OSS用户的密钥上传上去了。

11. [谷粒商城接口文档](https://easydoc.net/s/78237135/ZUqEdvA4/HqQGp9TI)
