# 谷粒商城

基于[Java项目《谷粒商城》架构师级Java项目实战，对标阿里P6-P7，全网最强](https://www.bilibili.com/video/BV1np4y1C7Yf)教学视频的实现代码。

## 软件版本

1. JDK：1.8
2. MYSQL：5.7
3. Redis：7.2

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
5. 
