package com.example.thread.threadClasses;

import org.springframework.util.StringUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/7/4
 */
public class MyTimerLock {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        CountDownLatch countDownLatch = new CountDownLatch(1);

        myThreadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                doWork();
                countDownLatch.countDown();
            }
        });
//        myThreadPoolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                doWork();
//                countDownLatch.countDown();
//            }
//        });
        countDownLatch.await();
        myThreadPoolExecutor.shutdown();
    }

    protected static void doWork() {
        boolean hasLock = false;
        try {
            hasLock = lock.tryLock(1, TimeUnit.SECONDS);    // trylock后 在finally里面的释放可能会引起异常
            while (!hasLock) {
                return;
            }
            //lock.lock();
            String fomatter = "thread id %s,%s";
            String msg = String.format(fomatter, Thread.currentThread().getId(), "begin");
            System.out.println(msg);
            Thread.sleep(3000);
            msg = String.format(fomatter, Thread.currentThread().getId(), "end");
            System.out.println(msg);
            System.out.println("down " + Thread.currentThread().getId());
        } catch (InterruptedException ex) {
            System.out.println(ex);
        } finally {
            System.out.println("finally");
            if (hasLock)
                lock.unlock();
        }
    }
}
