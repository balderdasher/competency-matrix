package com.mrdios.competencymatrix.springboot.example.rabbitmq;

import com.mrdios.competencymatrix.springboot.example.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author MrDios
 * @date 2017-08-08
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TopicRabbitTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void send() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
    }

    @Test
    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
    }
}