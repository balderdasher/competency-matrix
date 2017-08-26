package com.mrdios.competencymatrix.spring.aop.example.advance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 基于注解定位切点的切面测试
 *
 * @author mrdios
 * @date 2017-08-26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class BusinessServiceTest {
    @Autowired
    private BusinessService businessService;

    @Test
    public void transferMoney() throws Exception {
        businessService.transferMoney("Jack", "John", 3000.00);
    }

}