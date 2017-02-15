package com.mrdios.competencymatrix.springboot.example.web.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Using the ApplicationRunner or CommandLineRunner:
 * 实现上述两个接口，重写其中的run()方法，将在SpringApplication.run(…​)完成之前做一些特殊处理
 * 如果有多个需要执行的runer，可以实现org.springframework.core.Ordered 接口或者使用org.springframework.core.annotation.Order注解
 *
 * @author huxiong
 * @date 2016-11-28 10:37
 */
@Component
public class AppRunner implements ApplicationRunner {
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("application runner is running..............");
    }
}
