package com.ssscl.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class RedisChannelConfiguration {

    public static final String CHANNEL_NAME = "channel";
    public static Jedis getConnection() {
        Jedis jedis = new Jedis("localhost", 6379);
//        jedis.auth("password");
//        jedis.select(1);
        return jedis;
    }

    public static final JedisPoolConfig poolConfig = buildPoolConfig();

    private static final JedisPoolConfig buildPoolConfig() {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
        poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
        poolConfig.setNumTestsPerEvictionRun(3);
        poolConfig.setBlockWhenExhausted(true);
        return poolConfig;
    }

    public static Jedis getConnectionFromPool() {
        JedisPool jedisPool = new JedisPool(poolConfig, "localhost");
        return jedisPool.getResource();
    }
}
