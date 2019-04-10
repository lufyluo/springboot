package com.example.redis.infrastructure.redis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPubSub;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/10 15:40
 */
@Component
public class KeyExpiredListener extends JedisPubSub {
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe " + pattern + " " + subscribedChannels);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(
                "pattern = [" + pattern + "], channel = [" + channel + "], message = [" + message + "]");
        //收到消息 key的键值，处理过期提醒
    }
}
