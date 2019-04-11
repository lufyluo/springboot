package com.example.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/11 10:48
 */
@Component
public class MessageReceiver {

    @RabbitListener(queues = "test_queue_1")
    public void receive(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("receive消息接收时间:"+sdf.format(new Date()));
        System.out.println("receive接收到的消息:"+msg);
    }
    @RabbitListener(queues = "test_queue_1")
    public void receive1(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("receive1消息接收时间:"+sdf.format(new Date()));
        System.out.println("receive1接收到的消息:"+msg);
    }
    @RabbitListener(queues = "test_queue_1")
    public void receive2(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("receive2消息接收时间:"+sdf.format(new Date()));
        System.out.println("receive2接收到的消息:"+msg);
    }
}
