package com.mrdios.competencymatrix.springboot.example.rabbitmq;

import com.mrdios.competencymatrix.springboot.example.MainApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * RabbitMQ测试
 *
 * @author MrDios
 * @date 2017-08-07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class RabbitMqTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }

}