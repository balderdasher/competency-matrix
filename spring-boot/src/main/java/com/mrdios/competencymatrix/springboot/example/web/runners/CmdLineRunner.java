package com.mrdios.competencymatrix.springboot.example.web.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author huxiong
 * @date 2016-11-28 10:47
 */
@Component
public class CmdLineRunner implements CommandLineRunner {
    public void run(String... strings) throws Exception {
        System.out.println("commandLineRunner is running........");
    }
}
