package com.example.redis;

import com.example.redis.com.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisApplicationTests {

    private static final String CACHE_SHOP_KEY = "CACHE_SHOP_KEY";
    @Autowired
    RedisService redisService;

    @Test
    void contextLoads() {
        redisService.setStr("Long","小杰",60L * 60L);
        System.out.println(redisService.getKey("Long"));
    }

    @Test
    void test() {
        String key = CACHE_SHOP_KEY;
        String str = redisService.stringRedisTemplate.opsForValue().get(key);
        System.out.println(str);
    }
}
