package com.aiuiot.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关应用程序
 * EnableZuulProxy 代理 表示当前的应用是 Zuul Server
 * SpringCloudApplication：用于简化配置的组合注解
 * @Author aiuiot
 * @Date 2019-09-08 22:08
 **/
@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }
}
