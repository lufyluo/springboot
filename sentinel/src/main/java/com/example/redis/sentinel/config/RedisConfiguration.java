package com.example.redis.sentinel.config;

import com.example.redis.sentinel.core.JedisSentinelSlaveConnectionFactory;
import com.example.redis.sentinel.core.RedisRouteConst;
import com.example.redis.sentinel.core.RedisSourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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

    @Autowired
    private ApplicationContext applicationContext;

    @Primary
    @Bean(RedisRouteConst.WRITE)
    @ConditionalOnClass({ RedisTemplate.class })
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

    @Bean(RedisRouteConst.READ)
    @ConditionalOnClass({ RedisTemplate.class })
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

    @Bean
    public RedisTemplate<String, Object> stringSerializerRedisTemplate(@Autowired @Qualifier(RedisRouteConst.WRITE) RedisConnectionFactory connectionFactory) {
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);

        String beanName = RedisSourceContext.getCurrentDataSource();
        RedisConnectionFactory connectionFactory1 = (RedisConnectionFactory)applicationContext.getBean(beanName);
        if(connectionFactory1!=null)
        {
            System.out.println("change source " +beanName + " thread id: " + Thread.currentThread().getId());
            redisTemplate.setConnectionFactory(connectionFactory1);
        }else {
            redisTemplate.setConnectionFactory(connectionFactory);
        }
        System.out.println("init finish!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return redisTemplate;
    }
}
