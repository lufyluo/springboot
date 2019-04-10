package com.example.redis.controller;

import com.example.redis.infrastructure.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/10 11:30
 */
@RestController
@RequestMapping("/redis")
public class RedisRestController {
    @Autowired
    RedisUtil redisUtil;
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String get(@RequestParam String key){
        return redisUtil.get(key);
    }

    @RequestMapping(value = "load/{key}",method = RequestMethod.GET)
    public List<String> load(@PathVariable String key){
        return redisUtil.mget(key.split(","));
    }

    @RequestMapping(value = "set/{key}/{value}",method = RequestMethod.GET)
    public String set(@PathVariable String key, @PathVariable  String value){
        return redisUtil.set(key,value);
    }
}
