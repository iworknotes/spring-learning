package com.cc.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign测试
 *
 * @author YL.huang
 * @date 03/09/2020
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class TestFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestFeignApplication.class, args);
    }

}
