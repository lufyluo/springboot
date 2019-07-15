package com.example.redis.sentinel;

import com.example.redis.sentinel.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            RedisService redisService = (RedisService)ctx.getBean("redisServiceImpl");

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    redisService.get("w");
                }
            });

            t.start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    redisService.set("w", Thread.currentThread().getId() + "");
                }
            }).start();
        };
    }


}
