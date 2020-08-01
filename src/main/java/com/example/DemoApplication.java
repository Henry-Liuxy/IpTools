package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.example.mapper")
@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.mapper","com.example.service","com.example.service.impl","com.example.model","com.example.config","com.example.controller"})
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
//        try{
//            Thread.sleep(10000);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
    }
}
