package com.mrdios.competencymatrix.spring.aop.example.v_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 基于注解的一个Aspect方面模块的样本，定义了在各个点被调用的方法
 *
 * @author mrdios
 * @date 2017-08-23
 */
@Aspect
@Configuration
public class Logging {

    /**
     * 定义一个对于get前缀的方法都可用的切点，对于所有方法，通知都将会运行
     */
    @Pointcut("execution(* com.mrdios.competencymatrix.spring.aop.example.v_annotation.*.get*(..))")
    private void selectGet() {
    }

    /**
     * 前置通知：目标方法调用前执行
     */
    @Before("selectGet()")
    public void beforeAdvice() {
        System.out.println("anno-[beforeAdvice]get student profile.");
    }

    /**
     * 后置通知：目标方法调用后执行
     */
    @After("selectGet()")
    public void afterAdvice() {
        System.out.println("anno-[afterAdvice] student profile setup complete.");
    }

    /**
     * 成功后置通知：目标方法成功完成后调用
     */
    @AfterReturning("selectGet()")
    public void afterReturningAdvice() {
        System.out.println("anno-[afterReturningAdvice] student profile setup complete.");
    }

    /**
     * 异常后置通知：目标方法抛出指定的异常后执行此通知，可指定具体的异常
     *
     * @param e 目标方法抛出的具体异常
     */
    @AfterThrowing(value = "selectGet()", throwing = "e")
    public void afterThrowingAdvice(IllegalArgumentException e) {
        System.out.println("anno-[afterThrowingAdvice] an exception has been throw: " + e.toString());
    }

    /**
     * 环绕通知：方法执行前后运行的通知
     *
     * @param joinPoint 加入点
     * @return
     * @throws Throwable
     */
    @Around("selectGet()")
    public String aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("anno-[In around advice]");
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            System.out.println("Arguments passed: ");
            for (int i = 0; i < args.length; i++) {
                System.out.println("arg " + (i + 1) + ": " + args[i]);
            }
        }

        Object result = joinPoint.proceed(args);
        System.out.println("anno-[Out around advice]anno-Returning : " + result);
        return result.toString();
    }

    /**
     * 模拟日志记录
     */
    @AfterReturning(value = "execution(* com.mrdios.competencymatrix.spring.aop.example.v_annotation.*.save(..))",
            returning = "returnValue")
    private void log(JoinPoint joinPoint, Object returnValue) {
        System.out.println("@AfterReturning：模拟日志记录功能...");
        System.out.println("@AfterReturning：目标方法为：" +
                joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName());
        System.out.println("@AfterReturning：参数为：" +
                Arrays.toString(joinPoint.getArgs()));
        System.out.println("@AfterReturning：返回值为：" + returnValue);
        System.out.println("@AfterReturning：被织入的目标对象为：" + joinPoint.getTarget());
    }

}
