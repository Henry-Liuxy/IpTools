package com.example;

import com.example.config.WebSiteConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private WebSiteConfig webSiteConfig;

    @Test
    void contextLoads() {
        WebSiteConfig config = new WebSiteConfig();
//        System.out.println(webSiteConfig.getName());
        System.out.println(webSiteConfig);
    }

}
