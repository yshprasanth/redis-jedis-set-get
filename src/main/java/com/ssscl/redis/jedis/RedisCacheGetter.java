package com.ssscl.redis.jedis;

import redis.clients.jedis.Jedis;

import java.util.Scanner;

import static com.ssscl.redis.jedis.RedisChannelConfiguration.CHANNEL_NAME;

public class RedisCacheGetter {

    public static void main(String[] args) {
        Jedis jedis = RedisChannelConfiguration.getConnectionFromPool();
        RedisCache redisCache = new RedisCache(jedis);
        System.out.print("Reading the message from key [" + CHANNEL_NAME + "] every 5 seconds: ");

        while(true) {
            String value = redisCache.getFromCache(CHANNEL_NAME);
            System.out.println("Message get: " + value);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
