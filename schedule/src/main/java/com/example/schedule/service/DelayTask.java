package com.example.schedule.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/11 15:22
 */
@Component
public class DelayTask implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("begin to init delay task!");
        Timer timer=new Timer();//实例化Timer类
        timer.schedule(new TimerTask(){
            public void run(){
                System.out.println("over, quit!");
                this.cancel();}},5000);//五百毫秒
        Thread.sleep(10000);
    }
}
