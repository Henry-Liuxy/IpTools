package com.example.controller;

import com.example.config.WebSiteConfig;
import com.example.model.Person;
import com.example.unil.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    RedisUtil redisUtil;

    @GetMapping("/getRedis")
    public String getRedis() {
        String value="缓存未初始化";
        if(redisTemplate.opsForValue().get("myName1")!=null){
            value=redisTemplate.opsForValue().get("myName1").toString();
        }
        else{
            redisTemplate.opsForValue().set("myName1","123");
        }
        return value;
    }

    @GetMapping("/get/{key}")
    public String getCache(@PathVariable("key") String key) {
        String value="缓存尚未初始化";
        if(redisUtil.get(key)!=null){
            value=redisUtil.get(key).toString();
        }
//        else{
//            redisUtil.set("name","dlam_liu");
//        }
        return value;
    }

    @GetMapping("/set/{key}/{value}")
    public  String setCache(@PathVariable("key") String key, @PathVariable("value") String value){
      boolean flag= redisUtil.set(key,value);
      if(flag){
          return "设置缓存成功!";
      }
      else
      {
          return "缓存失败!";
      }
    }
}
