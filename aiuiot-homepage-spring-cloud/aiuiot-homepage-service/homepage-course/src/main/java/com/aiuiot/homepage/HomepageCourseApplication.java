package com.aiuiot.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * SpringBoot 启动入口
 * @Author aiuiot
 * @Date 2019-09-09 09:58
 **/
@EnableJpaAuditing  //启动记录填充
@EnableEurekaClient
@SpringBootApplication
public class HomepageCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomepageCourseApplication.class, args);
    }
}
