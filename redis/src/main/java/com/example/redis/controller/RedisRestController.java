package com.example.redis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/10 11:30
 */
@RestController
public class RedisRestController {
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String get(@RequestParam String key){
        return null;
    }
}
