package com.example.rabbitmq.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Timer;
import java.util.TimerTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceImplTest {
    @Autowired
    private MessageServiceImpl messageService;
    @Test
    public void sendMsg() {
        messageService.sendMsg("test_queue_1","hello i am normal msg");
        messageService.sendMsgDelay("test_queue_1","hello i am delay msg");
    }

    @Test
    public void timerTask() throws InterruptedException {

    }
}