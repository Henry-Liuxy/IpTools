package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test {
    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static void main(String[] args) {
        for(int i=0;i<1;i++){
            // 记录trace级别的信息
            logger.trace("log4j2日志输出：This is trace message.");
            // 记录debug级别的信息
            logger.debug("log4j2日志输出：This is debug message.");
            // 记录info级别的信息
            logger.info("log4j2日志输出：This is info message.");
            // 记录warn级别的信息
            logger.warn("log4j2日志输出：This is warn message.");
            // 记录error级别的信息
            logger.error("log4j2日志输出：This is error message.");
        }
    }
}
