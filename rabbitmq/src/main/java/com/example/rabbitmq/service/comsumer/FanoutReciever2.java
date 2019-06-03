package com.example.rabbitmq.service.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/12 15:48
 */
@Service
public class FanoutReciever2 extends BaseFanoutReciever {
    @RabbitListener(queues = "${spring.rabbitmq.fanoutQueue2}")
    public void recievedMessage(String spittle) throws InterruptedException {
        super.fanoutHanlder(spittle,"FanoutReciever2");
    }
}
