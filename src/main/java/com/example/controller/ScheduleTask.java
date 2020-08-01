package com.example.controller;

import com.example.unil.IpTools;
import com.example.unil.JsonTools;
import com.example.unil.RedisUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Configuration      //1.主要用于标记配置类
@EnableScheduling   // 2.开启定时任务
@EnableAsync
public class ScheduleTask {
    @Resource
    RedisUtil redisUtil;

    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
    //@Scheduled(cron = "0 0/10 * * * ?")
    //或直接指定时间间隔，例如：5秒
    @Scheduled(fixedRate=10000)
    @Async
    public void configureTasks() {
        Thread thread = Thread.currentThread();
        System.out.println("进入任务,threadId=" + thread.getId() + ", threadName=" + thread.getName());
        //设置ip
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            result = IpTools.getV4IP();
            //插入redis
            boolean flag = redisUtil.set("IP", result);
            if (flag) {
               // System.out.println("ScheduleTask成功: " + LocalDateTime.now());
                logger.info("ScheduleTask成功: " + LocalDateTime.now());
            } else {
               // System.err.println("ScheduleTask失败: " + LocalDateTime.now());
                logger.error("ScheduleTask失败: " + LocalDateTime.now());
            }
        } catch (Exception e) {
            //System.err.println("ScheduleTask异常: " + e.getMessage());
            logger.error("ScheduleTask异常: " + LocalDateTime.now());
        }
    }
}
