package com.example.redis.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class RedisService {

    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    public void setStr(String key, String value, Long time) {
        // 向redis中存入数据和缓存时间
        stringRedisTemplate.opsForValue().set(key, value);
        if (time != null) {
            // 设置过期时间并换算成指定单位
            stringRedisTemplate.expire(key, time , TimeUnit.SECONDS);
        }
    }

    public Object getKey (String key) {
        // 操作字符串,根据key获取缓存中的value
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void delKey(String key) {
        // 根据key删除缓存
        stringRedisTemplate.delete(key);
    }
}
