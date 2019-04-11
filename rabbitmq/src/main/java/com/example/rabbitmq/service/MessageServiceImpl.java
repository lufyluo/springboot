package com.example.rabbitmq.service;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/11 10:42
 */
@Service
public class MessageServiceImpl {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsgDelay(String queueName,String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息发送时间:"+sdf.format(new Date()));
        rabbitTemplate.convertAndSend("test_exchange", queueName, msg, message -> {
            message.getMessageProperties().setHeader("x-delay",20000);//delay 20S
            return message;
        });
    }
    public void sendMsg(String queueName,String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息发送时间:"+sdf.format(new Date()));
        rabbitTemplate.convertAndSend("test_exchange", queueName, msg);
    }
}
