package com.example.redis.sentinel.service;

import com.example.redis.sentinel.core.RedisRouteConst;
import com.example.redis.sentinel.core.RedisSourceRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/7/12
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    @RedisSourceRoute(route = RedisRouteConst.READ)
    public String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    @Override
    //@RedisSourceRoute()
    public void set(String key, String value) {
        System.out.println("begin set thread id: " + Thread.currentThread().getId());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        redisTemplate.opsForValue().set(key,value);
        System.out.println("end set thread id: " + Thread.currentThread().getId());
    }
}
