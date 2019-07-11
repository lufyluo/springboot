package com.example.thread.threadClasses;

import java.util.concurrent.TimeUnit;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/7/9
 */
public class ThreadSleepAndWait {
    private static final Object lockObj = new Object();

    public static void main(String[] args) {
        System.out.println();
    }
    protected static void doWork() {
        try {
            synchronized (lockObj){
                String fomatter = "thread id %s,%s";
                String msg = String.format(fomatter, Thread.currentThread().getId(), "begin");
                System.out.println(msg);
                lockObj.wait(3000);
                msg = String.format(fomatter, Thread.currentThread().getId(), "end");
                System.out.println(msg);
                System.out.println("down " + Thread.currentThread().getId());
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }finally {
            lockObj.notify();
        }
    }
}
