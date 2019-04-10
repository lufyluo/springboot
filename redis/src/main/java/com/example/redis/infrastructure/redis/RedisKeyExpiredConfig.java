package com.example.redis.infrastructure.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/10 15:38
 */
@Component
public class RedisKeyExpiredConfig implements CommandLineRunner {
    @Autowired
    private JedisPool jedisPool;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("redis 发布订阅注册！");
        Jedis jedis =jedisPool.getResource();
        keyListentConfigMethod(jedis);
        jedis.psubscribe(new KeyExpiredListener(), "__keyevent@*__:expired");//过期队列
    }

    public void keyListentConfigMethod(Jedis jedis){
        System.out.println(">>>>>>>>>>>>>>>>>>启动监听实现的redisKey<<<<<<<<<<<<<<<<<<");
        String parameter = "notify-keyspace-events";
        List<String> notify = jedis.configGet(parameter);
        if(notify.get(1).equals("")){
            jedis.configSet(parameter, "Ex"); //过期事件
        }
    }
}
