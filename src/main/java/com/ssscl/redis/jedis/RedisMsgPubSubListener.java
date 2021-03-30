package com.ssscl.redis.jedis;

import redis.clients.jedis.JedisPubSub;

public class RedisMsgPubSubListener extends JedisPubSub {
    @Override
    public void subscribe(String... channels) {
        super.subscribe(channels);
    }

    @Override
    public void unsubscribe(String... channels) {
        super.unsubscribe(channels);
    }

    @Override
    public void psubscribe(String... patterns) {
        super.psubscribe(patterns);
    }

    @Override
    public void punsubscribe(String... patterns) {
        super.punsubscribe(patterns);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("onSubscribe-channel:" + channel + " is been subscribed:" + subscribedChannels);
    }

    @Override
    public void onMessage(String channel, String message) {
        System.out.println("onMessage-channel:" + channel + " message :" + message);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("onUnsubscribe-channel:" + channel + " is been subscribed:" + subscribedChannels);
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPUnsubscribe-pattern:" + pattern + " is been subscribed:" + subscribedChannels);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println("onPMessage-pattern:" + pattern + " channel:" + channel + " message :" + message);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPUnsubscribe-pattern:" + pattern + " is been subscribed:" + subscribedChannels);
    }
}
