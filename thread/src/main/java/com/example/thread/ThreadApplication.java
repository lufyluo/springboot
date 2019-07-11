package com.example.thread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
public class ThreadApplication {

    private static final Object lockObj = new Object();
    public static void main(String[] args) {
        SpringApplication.run(ThreadApplication.class, args);
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockObj) {
                    System.out.println("enter thread1...");
                    System.out.println("thread1 is waiting...");
                    try {
                        //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                        Long now = System.currentTimeMillis();
                        lockObj.wait(2000);
                        System.out.println("我等了" + (System.currentTimeMillis() - now));
                        //Thread.sleep(2000);
                        //lockObj.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread1 is going on ....");
                    System.out.println("thread1 is over!!!");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 is start");
                synchronized (lockObj) {
                    System.out.println("enter thread2...");
                    System.out.println("thread2 is waiting...");
                    try {
                        //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        //lockObj.notify();
                    }
                    System.out.println("thread2 is going on ....");
                    System.out.println("thread2 is over!!!");
                }
            }
        }).start();
    }

}
