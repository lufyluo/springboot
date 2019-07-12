package com.example.redis.sentinel.core;

import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/7/12
 */
public class RedisSourceContext {
    private static final ThreadLocal<String> contextHolder = ThreadLocal.withInitial(() ->RedisRouteConst.WRITE );

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
