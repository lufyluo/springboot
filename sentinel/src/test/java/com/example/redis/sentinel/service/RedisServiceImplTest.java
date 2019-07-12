package com.example.redis.sentinel.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceImplTest {
    @Autowired
    private RedisService redisService;

    @Test
    public void get() {
        System.out.println(redisService.get("w"));
    }

    @Test
    public void set() {
        redisService.set("w", "write");
    }
}