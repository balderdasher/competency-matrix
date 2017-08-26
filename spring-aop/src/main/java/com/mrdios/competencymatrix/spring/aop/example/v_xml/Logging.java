package com.mrdios.competencymatrix.spring.aop.example.v_xml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 一个Aspect方面模块的样本，定义了在各个点被调用的方法
 *
 * @author mrdios
 * @date 2017-08-23
 */
public class Logging {

    /**
     * 前置通知：目标方法调用前执行
     */
    public void beforeAdvice() {
        System.out.println("xml-[beforeAdvice]get student profile.");
    }

    /**
     * 后置通知：目标方法调用后执行
     */
    public void afterAdvice() {
        System.out.println("xml-[afterAdvice] student profile setup complete.");
    }

    /**
     * 成功后置通知：目标方法成功完成后调用
     */
    public void afterReturningAdvice() {
        System.out.println("xml-[afterReturningAdvice] student profile setup complete.");
    }

    /**
     * 异常后置通知：目标方法抛出指定的异常后执行此通知，可指定具体的异常
     *
     * @param e 目标方法抛出的具体异常
     */
    public void afterThrowingAdvice(IllegalArgumentException e) {
        System.out.println("xml-[afterThrowingAdvice] an exception has been throw: " + e.toString());
    }

    /**
     * 环绕通知：方法执行前后运行的通知
     *
     * @param joinPoint 加入点
     * @return
     * @throws Throwable
     */
    public String aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("xml-[In around advice]");
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            System.out.println("Arguments passed: ");
            for (int i = 0; i < args.length; i++) {
                System.out.println("arg " + (i + 1) + ": " + args[i]);
            }
        }

        Object result = joinPoint.proceed(args);
        System.out.println("xml-[Out around advice]xml-Returning : " + result);
        return result.toString();
    }
}
