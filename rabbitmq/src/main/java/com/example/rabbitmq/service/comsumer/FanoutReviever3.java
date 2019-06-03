package com.example.rabbitmq.service.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/5/27
 */
@Service
public class FanoutReviever3  extends BaseFanoutReciever{
    @RabbitListener(queues = "${spring.rabbitmq.fanoutQueue1}")
    public void recievedMessage(String spittle) throws InterruptedException {
        super.fanoutHanlder(spittle,"FanoutReciever3");
    }
}
