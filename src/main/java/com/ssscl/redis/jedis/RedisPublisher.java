package com.ssscl.redis.jedis;

import redis.clients.jedis.Jedis;

import java.util.Scanner;

import static com.ssscl.redis.jedis.RedisChannelConfiguration.CHANNEL_NAME;

public class RedisPublisher {

    public static void main(String[] args) {
        Jedis jedis = RedisChannelConfiguration.getConnection();
        while (true) {
            System.out.print("Please enter the message is forthcoming:");
            Scanner str = new Scanner(System.in);
            String value = str.next();
            // make an announcement
            publish(jedis, CHANNEL_NAME, value);
            System.out.println("Message published, please see the subscribers state: " + value);
        }
    }

    public static void publish(Jedis jedis, String channel, String msg) {
        jedis.publish(channel, msg);
    }
}
