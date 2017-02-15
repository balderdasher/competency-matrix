## Spring-boot开发入门 ##

### 1、spring-boot的目标 ###
- 为所有基于`spring`的开发提供一种更快和更广泛的入门体验
- 为常见的多类项目提供非功能性的特性，例如`嵌入式服务器`、`安全`、`标准`、`健康检查`、`外部配置`等
- 不需要代码生成，几乎没有XML配置

### 2、快速入门demo ###

#### 2.1 新建maven项目并配置依赖 ####
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.mrdios</groupId>
  <artifactId>spring-boot-demo</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>spring-boot-demo</name>
  <description>Demo project for Spring-boot</description>

  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.2.5.RELEASE</version>
    <relativePath/>
  </parent>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <java.version>1.8</java.version>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
</project>

```
#### 2.2 创建src/main/Java/Application.java ####
```
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String greeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

#### 2.3 运行Application类中的main（）方法 ###
直接运行此方法启动应用，因为内嵌了tomcat容器，在浏览器访问`http://localhost:8080`可即可看到效果：

`hello world`

### web项目使用模板引擎 ###

以使用`freemarker`模板引擎为例，pom中加入如下依赖：
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-freemarker</artifactId>
    <version>${spring.boot.version}</version>
</dependency>
```
编写控制层类`MyController`：
```
package com.mrdios.springboot.example.web.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/test")
public class MyController {


    @RequestMapping("/html")
    public String test(Model model) {
        model.addAttribute("time",new Date());
        model.addAttribute("message",this.message);
        return "index";
    }
}
```
在resources目录下新建模板目录`templates`并编写页面`index.html`
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>home</title>
</head>
<body>
<h1>welcome</h1>
Date: ${time?date}
<br>
Time: ${time?time}
<br>
Message: ${message}
</body>
</html>
```
运行程序访问`http://localhost:8080/test/html`即可看到：

![](http://i.imgur.com/O5P8hO4.png)
