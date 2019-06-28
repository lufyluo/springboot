package com.example.redistemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/21
 */
@RestController
@RequestMapping("/reds")
public class RedisController {
    @Autowired
    RedisTemplate redisTemplate;
}
