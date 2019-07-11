package com.example.redis.sentinel.config;

import com.example.redis.sentinel.core.JedisSentinelSlaveConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {
    @Value("${spring.redis.password}")
    private String redisPasswd;

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public RedisTemplate<String, Object> stringSerializerRedisTemplate() {
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        return redisTemplate;
    }

    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
                .master("mymaster")
                .sentinel("sentinel1.taxi.redis.vvip-u.com", 26379)
                .sentinel("sentinel2.taxi.redis.vvip-u.com", 26379)
                .sentinel("sentinel3.taxi.redis.vvip-u.com", 26379);
        sentinelConfig.setPassword(RedisPassword.of(redisPasswd));
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(sentinelConfig);
        System.out.println(jedisConnectionFactory.getClientConfiguration().getClientName());
        return jedisConnectionFactory;
    }

    @Bean("read")
    public RedisConnectionFactory jedisReadConnectionFactory() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
                .master("mymaster")
                .sentinel("sentinel1.taxi.redis.vvip-u.com", 26379)
                .sentinel("sentinel2.taxi.redis.vvip-u.com", 26379)
                .sentinel("sentinel3.taxi.redis.vvip-u.com", 26379);
        sentinelConfig.setPassword(RedisPassword.of(redisPasswd));
        JedisConnectionFactory jedisConnectionFactory = new JedisSentinelSlaveConnectionFactory(sentinelConfig);
        System.out.println(jedisConnectionFactory.getClientConfiguration().getClientName());
        return jedisConnectionFactory;
    }
}
