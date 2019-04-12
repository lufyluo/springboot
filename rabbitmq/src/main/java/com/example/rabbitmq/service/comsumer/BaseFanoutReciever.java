package com.example.rabbitmq.service.comsumer;

import com.example.rabbitmq.service.model.Spittle;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/12 17:42
 */
public abstract class BaseFanoutReciever {
    protected void fanoutHanlder(Spittle spittle) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("FanoutReciever1 Recieved Message: " + spittle);
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        System.out.println("FanoutReciever1: " + totalTimeMillis);
    }

    protected  void fanoutHanlder(String spittle,String id){
        System.out.println(id + " Recieved Message: " + spittle);
    }
}
