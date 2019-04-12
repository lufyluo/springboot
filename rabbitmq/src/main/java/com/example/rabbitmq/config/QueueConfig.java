package com.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/11 10:32
 */
@Configuration
public class QueueConfig {
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.fanoutQueue1}")
    private String fanoutExchange1;
    @Value("${spring.rabbitmq.fanoutQueue2}")
    private String fanoutExchange2;
    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange("test_exchange", "x-delayed-message", true, false, args);
    }

    @Bean("apple")
    public FanoutExchange exchange() {
        return new FanoutExchange(exchange);
    }

    @Bean
    public Queue queue() {
        Queue queue = new Queue("test_queue_1", true);
        return queue;
    }

    @Bean
    public Queue fanoutQueue1() {
        Queue queue = new Queue(fanoutExchange1, true);
        return queue;
    }
    @Bean
    public Queue fanoutQueue2() {
        Queue queue = new Queue(fanoutExchange2, true);
        return queue;
    }

    @Bean
    public Binding fanoutBinding1() {
        return BindingBuilder.bind(fanoutQueue1()).to(exchange());
    }
    @Bean
    public Binding fanoutBinding2() {
        return BindingBuilder.bind(fanoutQueue2()).to(exchange());
    }


    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(delayExchange()).with("test_queue_1").noargs();
    }
}
