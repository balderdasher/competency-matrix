package com.mrdios.competencymatrix.spring.aop.example.v_annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 基于注解的切面测试
 *
 * @author mrdios
 * @date 2017-08-26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class AnnotationAspectTest {
    @Autowired
    private Student student;

    @Test
    public void testAdvices() throws Exception {
        student.getName();
    }

    @Test
    public void testAfterThrowingAdvice() throws Exception {
        student.getAnException();
    }

    @Test
    public void testLog() throws Exception {
        student.save(student);
    }

    /**
     * 以变成方式调用切面
     */
    @Test
    public void testProgreamToCallAspect() {
        // 为被代理对象创建Aspectj代理工厂
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(student);
        // 为工厂添加切面
        proxyFactory.addAspect(Logging.class);
        // 获取代理对象
        Student student = proxyFactory.getProxy();//此处转型错误
        // 调用代理方法
        student.getName();
    }

}