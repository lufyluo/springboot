package com.example.rabbitmq.service.sender;

import com.example.rabbitmq.service.model.Spittle;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/12 15:32
 */
@Service
public class FanoutSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("apple")
    private FanoutExchange exchange;

    int dots = 0;
    int count = 0;

    //@Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        Spittle spittle = new Spittle(1,"");
        StringBuilder builder = new StringBuilder("Hello");
        if (dots++ == 3) {
            dots = 1;
        }
        for (int i = 0; i < dots; i++) {
            builder.append('.');
        }

        builder.append(Integer.toString(++count));
        String message = builder.toString();
        spittle.setMessage(message);
        rabbitTemplate.convertAndSend(exchange.getName(),null, spittle);
        System.out.println(" [x] Sent '" + message + "'");
    }

    public void send(String hello) {
        Spittle spittle = new Spittle(1,hello);
        rabbitTemplate.convertAndSend(exchange.getName(),null, spittle.toString());
        System.out.println(" [x] Sent '" + hello + "'");
    }
}
