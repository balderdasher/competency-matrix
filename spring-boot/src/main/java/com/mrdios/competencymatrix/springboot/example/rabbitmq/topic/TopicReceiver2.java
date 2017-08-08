package com.mrdios.competencymatrix.springboot.example.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author MrDios
 * @date 2017-08-08
 */
@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver2 {

    @RabbitHandler
    public void process(String messages) {
        System.out.println("Topic Receiver2 : " + messages);
    }
}
