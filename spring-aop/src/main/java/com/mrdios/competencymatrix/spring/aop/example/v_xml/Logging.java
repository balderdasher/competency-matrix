package com.mrdios.competencymatrix.spring.aop.example.v_xml;

/**
 * 一个Aspect方面模块的样本，定义了在各个点被调用的方法
 *
 * @author mrdios
 * @date 2017-08-23
 */
public class Logging {

    /**
     * 前置通知
     */
    public void beforeAdvice() {
        System.out.println("[beforeAdvice]setup student profile.");
    }
}
