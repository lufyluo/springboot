package com.example.redistemplate.redis;

import com.example.redistemplate.bean.DataConf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    String key="key";
    String group = "group";
    String val = "val";
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void expiredTest() {
        redisTemplate.opsForValue().set("test","aaa");
        String stt =(String) redisTemplate.opsForValue().get("test");
        boolean re = redisTemplate.opsForValue().setIfAbsent("test","aaa",1,TimeUnit.MINUTES);
    }

    @Test
    public void add() {
        Map<String,DataConf> map=new HashMap<String,DataConf>();
        for (int i = 0; i < 5; i++) {
            DataConf dataConf = new DataConf();
            dataConf.setKey(key+i);
            dataConf.setGroup(group+i);
            dataConf.setVal(val+i);
            map.put(key+i,dataConf);
        }
        redisTemplate.opsForHash().putAll("maps",map);
    }

    @Test
    public void get() {
        Map<String,DataConf> map=redisTemplate.opsForHash().entries("maps");
        System.out.println(map.size());
    }

    @Test
    public void addSet() {
        Set<DataConf> sets = new HashSet<DataConf>();

        for (int i = 0; i < 5; i++) {
            DataConf dataConf = new DataConf();
            dataConf.setKey(key+i);
            dataConf.setGroup(group+i);
            dataConf.setVal(val+i);
            sets.add(dataConf);
        }
        final byte[] rawKey = redisTemplate.getDefaultSerializer().serialize("sets1");
        redisTemplate.executePipelined(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                for (DataConf str : sets) {
                    byte[] rawStr =redisTemplate.getDefaultSerializer().serialize(str);//在set中添加数据
                    connection.sAdd(rawKey,rawStr);
                }
                connection.closePipeline();
                return null;
            }
        });
    }
    @Test
    public void getSet() {
        Set<DataConf> sets=redisTemplate.opsForSet().members("sets1");
        System.out.println(sets.size());
    }

    @Test
    public void addObj() {
        redisTemplate.opsForValue().set("aa","asdasdsad");
    }
    @Test
    public void expiredSet() {
       redisTemplate.expire("sets1",20, TimeUnit.SECONDS);
    }
}
