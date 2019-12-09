package com.bluedon.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

/**
 * Created by landun on 2019/10/18.
 */
@Component("redisClient")
public class RedisClient {
    @Autowired
    private JedisPool jedisPool;

    //字符串get/set
    public void set(String key, String value) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

    public String get(String key) throws Exception {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }


    //hash get/set/ mhget/ mhset
    public String hget(String key, String field) throws Exception {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hget(key, field);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

    //hash get/set/ mhget/ mhset
    public  Map<String, String> hgetAll(String key) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hgetAll(key);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }




    public long hset(String key, String filed, String value) throws Exception {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hset(key, filed, value);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }


    public String mHset(String key, Map<String, String> map) throws Exception {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (map != null) {
                return jedis.hmset(key, map);
            }

        } finally {
            //返还到连接池
            jedis.close();
        }
        return null;
    }


    public Long del(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (key != null) {
                return jedis.del(key);
            }
        } finally {
            //返还到连接池
            jedis.close();
        }
        return null;
    }


    public String hmset(String key, Map<String, String> hash) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (key != null && hash.size() > 0) {
                return jedis.hmset(key, hash);
            }
        } finally {
            //返还到连接池
            jedis.close();
        }
        return null;
    }

}
