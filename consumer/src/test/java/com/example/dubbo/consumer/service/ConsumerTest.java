package com.example.dubbo.consumer.service;

import com.example.dubbo.consumer.ConsumerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ConsumerApplication.class})
public class ConsumerTest {
    @Resource
    private UserServiceImpl userServiceImpl;

    @Test
    public void get() {
        int result = userServiceImpl.get();
        System.out.println(result);
    }
}