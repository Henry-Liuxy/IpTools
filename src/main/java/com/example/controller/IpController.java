package com.example.controller;

import com.example.unil.IpTools;
import com.example.unil.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class IpController {
    @Resource
    RedisUtil redisUtil;
    /*
    获取服务器外网IP
     */
    @RequestMapping("/ip")
    public String getIp(){
        String data="";
        Map<String, Object> result =(Map<String, Object>)redisUtil.get("IP");
        if(result.size()>0){
            if((boolean)result.get("state")== true){
                    data=result.get("message")+"; 当前IP为:<br><br> "+result.get("entity");
            }
        }
        else{
            data="IP获取失败";
        }
        return  data;
    }
}
