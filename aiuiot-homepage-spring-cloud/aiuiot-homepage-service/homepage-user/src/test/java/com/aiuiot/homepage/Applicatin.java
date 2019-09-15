package com.aiuiot.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 测试用例启动入口
 * @Author aiuiot
 * @Date 2019/9/15 12:29 上午
 **/
@EnableFeignClients(basePackages = {"com.aiuiot.homepage"})
@SpringBootApplication
public class Applicatin {
    public static void main(String[] args) {
        SpringApplication.run(Applicatin.class, args);
    }
}
