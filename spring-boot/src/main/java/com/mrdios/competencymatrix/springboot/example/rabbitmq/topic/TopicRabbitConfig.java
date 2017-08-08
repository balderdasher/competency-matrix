package com.mrdios.competencymatrix.springboot.example.rabbitmq.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topic
 *
 * @author MrDios
 * @date 2017-08-08
 */
@Configuration
public class TopicRabbitConfig {
    static final String message = "topic.message";
    static final String messages = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(messages);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with(message);
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

}
