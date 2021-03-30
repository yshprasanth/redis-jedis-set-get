package com.ssscl.redis.jedis;

import redis.clients.jedis.Jedis;

import static com.ssscl.redis.jedis.RedisChannelConfiguration.CHANNEL_NAME;

public class RedisConsumer {

    public static void main(String[] args) {
        Jedis jedis = RedisChannelConfiguration.getConnection();
        RedisMsgPubSubListener redisMsgPubSubListener = new RedisMsgPubSubListener();

        subscribe(jedis, redisMsgPubSubListener, CHANNEL_NAME);
    }

    public static void subscribe(Jedis jedis, RedisMsgPubSubListener listener, String channel) {
        jedis.subscribe(listener, channel);
    }
}
