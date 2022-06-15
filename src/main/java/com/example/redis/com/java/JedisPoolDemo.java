package com.example.redis.com.java;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

// redid连接池使用
public class JedisPoolDemo {
    public static void main(String[] args) {
        // 构造连接池配置信息
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置最大连接池
        jedisPoolConfig.setMaxTotal(50);
        // 构造连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
        // 从连接池中获取连接
        Jedis jedis = jedisPool.getResource();
        // 读取数据
        System.out.println(jedis.get("name"));
        // 将连接还回到连接池中
        jedisPool.returnResource(jedis);
        // 释放连接池
        jedisPool.close();
    }
}
