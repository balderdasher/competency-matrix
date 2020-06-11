# 2-11 聚合工程整合springboot #

1. 引入依赖 parent

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.2.2.RELEASE</version>
    <relativePath />
</parent>
```

2. 设置资源属性

```xml
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <java.version>1.8</java.version>
</properties>
```

3. 引入依赖 dependency

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
        <exclusions>
            <exclusion>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-logging</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
	<!-- 这个依赖可不引入,starter-web中已引入
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-configuration-processor</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

问题：项目打包时如何跳过测试？

在`pom`文件中添加`properties`属性配置：`<skipTests>true</skipTests>`

注意点：

1. 顶级工程中引入`spring-boot-starter-parent`就行了，它的作用主要是各个子模块中若用到springboot相关starter时统一管理包版本，具体使用到的starter应该在具体模块的pom中去引入而不是在顶级工程pom中，否则就会造成`common`等类似公用jar包引入了一些不需要使用的starter
