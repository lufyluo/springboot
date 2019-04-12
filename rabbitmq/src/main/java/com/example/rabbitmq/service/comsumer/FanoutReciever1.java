package com.example.rabbitmq.service.comsumer;

import com.example.rabbitmq.service.model.Spittle;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/12 15:47
 */
@Service
public class FanoutReciever1 extends BaseFanoutReciever{
    @RabbitListener(queues = "${spring.rabbitmq.fanoutQueue1}")
    public void recievedMessage(String spittle) throws InterruptedException {
        super.fanoutHanlder(spittle,"FanoutReciever1");
    }
}
