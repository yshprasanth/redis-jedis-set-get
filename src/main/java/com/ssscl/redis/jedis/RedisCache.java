package com.ssscl.redis.jedis;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class RedisCache {
    private final Jedis jedis;

    public RedisCache(Jedis jedis) {
        this.jedis = jedis;
    }

    public void setInCache(String key, String value) {
        jedis.set(key, value);
    }

    public String getFromCache(String key) {
        return jedis.get(key);
    }

    public void pushToListCache(String key, String value) {
        jedis.lpush(key, value);
    }

    public void popFromListCache(String key, String value) {
        jedis.rpop(key);
    }

    public void addToSetCache(String key, String value) {
        jedis.sadd(key, value);
    }

    public Set<String> getFromSetCache(String key) {
        return jedis.smembers(key);
    }

    public boolean isExistsSetCache(String key, String value) {
        return jedis.sismember(key, value);
    }

    public void addToHashCache(String hashMapName, String key, String value) {
        jedis.hset(hashMapName, key, value);
    }

    public String getFromHashCache(String hashMapName, String key) {
        return jedis.hget(hashMapName, key);
    }

    public Map<String, String> getAllFromHashCache(String hashMapName) {
        return jedis.hgetAll(hashMapName);
    }
}
