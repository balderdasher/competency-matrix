package com.mrdios.competencymatrix.springboot.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * SpringBootApplication注解相当于@Configuration, @EnableAutoConfiguration 和 @ComponentScan合用
 *
 * @author huxiong
 * @date 2016-11-24 16:27
 */
@SpringBootApplication
@MapperScan("com.mrdios.competencymatrix.springboot.example.mybatis.*mapper")
public class MainApplication extends SpringBootServletInitializer {
    private static SpringApplication app;

    public static void main(String[] args) {
        // 默认运行方式
//        app.run(MainApplication.class,args);

        // 自定义参数运行
//        app = new SpringApplication(MainApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);//关闭打印banner
//        app.run(args);
        // 链式api
        new SpringApplicationBuilder()
                .sources(MainApplication.class)
                .bannerMode(Banner.Mode.LOG)
                .run(args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}