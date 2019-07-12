package com.example.redis.sentinel.service;

public interface RedisService {
    String get(String key);
    void set(String key,String value);

}
