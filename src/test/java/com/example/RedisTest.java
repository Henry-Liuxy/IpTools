package com.example;

import com.example.model.Person;
import com.example.unil.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RedisTest {
    static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Resource
    RedisUtil redisUtil;

    @Test
    void redisset() {
        Person userEntity = new Person();
        userEntity.setName("zhangsan123");
        userEntity.setSex("男");

        redisUtil.set("user", userEntity, ExpireTime);

        // redisUtil.set(key,value);
    }

    @Test
    void redisget() {
        String key = "";
        redisUtil.get(key);
    }

    @Test
    void expire() {
        String key = "";
        redisUtil.expire(key, ExpireTime);
    }
}
