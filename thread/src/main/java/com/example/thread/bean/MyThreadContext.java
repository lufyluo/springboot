package com.example.thread.bean;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/7/12
 */
public class MyThreadContext {
    private static final ThreadLocal<String> contextHolder = ThreadLocal.withInitial(() ->"write" );

    public static void setCurrentDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }

    public static String getCurrentDataSource() {
        return contextHolder.get();
    }

    public static void removeDataSource() {
        contextHolder.set(null);
        contextHolder.remove();
    }
}
