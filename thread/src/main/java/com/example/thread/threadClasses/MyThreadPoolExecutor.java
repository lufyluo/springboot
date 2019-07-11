package com.example.thread.threadClasses;

import com.example.thread.bean.OladBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/7/1
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    private final AtomicLong taskNums = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize){
        super(corePoolSize, maximumPoolSize, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        String msg = String.format("beforeExecute thread %s start %s",t.getName(),t.getName());
        System.out.println(msg);
        startTime.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        Long endTime = System.nanoTime();
        Long taskTime = endTime - startTime.get();
        String msg = String.format("afterExecute time %s taskNum %s total %s",taskTime,taskNums.addAndGet(1),totalTime.addAndGet(taskTime));
        System.out.println(msg);
    }

    @Override
    protected void terminated() {
        super.terminated();
        String msg = String.format("terminated  taskNum %s total %s",taskNums.get(),totalTime.get());
        System.out.println(msg);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(5,5,0,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        CountDownLatch countDownLatch = new CountDownLatch(20);
        final int[] a = {0};
        String sdas="";
        List<OladBean> list = new ArrayList<>();
        runThread(myThreadPoolExecutor, countDownLatch);
//        while (((MyThreadPoolExecutor) myThreadPoolExecutor).taskNums.get()<20){
//            System.out.println("still");
//            Thread.sleep(1000);
//        }
        //myThreadPoolExecutor.awaitTermination(0,TimeUnit.SECONDS);
        countDownLatch.await();
        //myThreadPoolExecutor.shutdown();
//        while (!myThreadPoolExecutor.isTerminated()){
//            System.out.println("not done");
//            Thread.sleep(1000);
//        }
        //Thread.sleep(5000);
        //myThreadPoolExecutor.shutdown();
        myThreadPoolExecutor.awaitTermination(3,TimeUnit.SECONDS);
        System.out.println("=============" + myThreadPoolExecutor.getActiveCount());

        runThread(myThreadPoolExecutor, countDownLatch);


    }

    private static void runThread(ThreadPoolExecutor myThreadPoolExecutor, CountDownLatch countDownLatch) {
        if(myThreadPoolExecutor.isTerminated())
        {
            System.out.println("no no no");
            return;
        }
        for (int i =0;i<20;i++){
            myThreadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    String msg = String.format("thread %s",Thread.currentThread().getId());

                    try {
                        Thread.sleep(3000);
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(msg);
                }
            });
        }
    }
}
