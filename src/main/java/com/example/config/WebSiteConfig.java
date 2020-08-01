package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "website")
public class WebSiteConfig {
    private String name;
    private String domain;
    private String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "WebSiteConfig{" +
                "name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
