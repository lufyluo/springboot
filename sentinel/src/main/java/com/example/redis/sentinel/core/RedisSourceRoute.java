package com.example.redis.sentinel.core;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisSourceRoute {
    String route() default RedisRouteConst.WRITE;
}
