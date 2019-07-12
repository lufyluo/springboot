package com.example.redis.sentinel.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigurationTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void testConect() {
        String value = (String)redisTemplate.opsForValue().get("aTest");
        System.out.println(value);
    }
    @Test
    public void testSet() {
        redisTemplate.opsForValue().set("aTest","lufy");
    }

}