package com.ssscl.redis.jedis;

import redis.clients.jedis.Jedis;

import java.util.Scanner;

import static com.ssscl.redis.jedis.RedisChannelConfiguration.CHANNEL_NAME;

public class RedisCacheSetter {

    public static void main(String[] args) {
        Jedis jedis = RedisChannelConfiguration.getConnectionFromPool();
        RedisCache redisCache = new RedisCache(jedis);
        while (true) {
            System.out.print("Please enter the message to set in key [" + CHANNEL_NAME + "]: ");
            Scanner str = new Scanner(System.in);
            String value = str.next();
            redisCache.setInCache(CHANNEL_NAME, value);
            System.out.println("Message set: " + value);
        }
    }
}
