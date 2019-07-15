package com.example.redis.sentinel.aop;

import com.example.redis.sentinel.core.RedisSourceContext;
import com.example.redis.sentinel.core.RedisSourceRoute;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.reflect.Method;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/7/12
 */
@Order(0)
@Aspect
@Component
public class RedisDataSourceAspect {
    @Autowired
    private ApplicationContext appContext;

    @Pointcut("@annotation(com.example.redis.sentinel.core.RedisSourceRoute)")
    public void dataSourcePointCut() {
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            RedisSourceRoute redisSourceRoute = method.getAnnotation(RedisSourceRoute.class);
            RedisSourceContext.setCurrentDataSource(redisSourceRoute.route());
            Object result = joinPoint.proceed();
            return result;
        }finally {
            RedisSourceContext.removeDataSource();
        }

    }

}
