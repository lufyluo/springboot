package com.example.dubbo.provider.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.UUID;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/15
 */
@Aspect
@Order(4)
@Component
public class LogAspect {
    @Pointcut("execution(public * com.example.dubbo.provider.service..*(..))")
    public void declearJoinPointExpression(){}
    @Around(value="declearJoinPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint)throws Throwable{
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        Object result =  joinPoint.proceed();
        stopwatch.stop();
        System.out.println(String.format("耗时(%d),%s,invokeKey:%s",stopwatch.getTotalTimeMillis()));
        return result;
    }
}
