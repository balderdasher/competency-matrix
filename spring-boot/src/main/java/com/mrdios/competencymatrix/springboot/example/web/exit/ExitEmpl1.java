package com.mrdios.competencymatrix.springboot.example.web.exit;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * 应用结束的时候返回特殊的code
 * @author huxiong
 * @date 2016-11-28 11:11
 */
@Component
public class ExitEmpl1 implements ExitCodeGenerator {
    public int getExitCode() {
        System.out.println("application is ending........");
        return 47;
    }
}
