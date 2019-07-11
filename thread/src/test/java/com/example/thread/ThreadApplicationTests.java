package com.example.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class ThreadApplicationTests {
    @Test
    public void contextLoads() {
        Object obj = new Object();
        try {
            synchronized (obj){
                obj.wait();
                System.out.println("aaaaaa");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
