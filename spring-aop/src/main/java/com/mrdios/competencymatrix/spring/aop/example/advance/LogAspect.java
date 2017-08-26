package com.mrdios.competencymatrix.spring.aop.example.advance;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 日志记录切面
 *
 * @author mrdios
 * @date 2017-08-26
 */
@Aspect
@Configuration
public class LogAspect {

    @Pointcut("@annotation(LogRequired)")
    private void logRequired() {
    }

    @Before("logRequired()")
    public void whoIsRunning(JoinPoint joinPoint) {
        String who = joinPoint.getSignature()
                .getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName();
        System.out.println("@Before: 当前业务方法@" + who);
    }

    @AfterReturning(value = "logRequired()", returning = "returnValue")
    public void log(JoinPoint joinPoint, Object returnValue) {
        System.out.println("@AfterReturning：模拟日志记录功能...");
        System.out.println("@AfterReturning：目标方法为：" +
                joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName());
        System.out.println("@AfterReturning：参数为：" +
                Arrays.toString(joinPoint.getArgs()));
        System.out.println("@AfterReturning：返回值为：" + returnValue);
    }
}
