package com.mrdios.competencymatrix.spring.aop.example.v_xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring Aop测试
 *
 * @author mrdios
 * @date 2017-08-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class SpringAopTest {
    @Autowired
    private Student student;

    @Test
    public void beforeAdvice() throws Exception {
        student.getName();
        student.getAge();
    }

}