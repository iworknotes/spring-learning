package com.cc.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author YL.huang
 * @date 03/09/2020
 */
@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
public class TestHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestHystrixApplication.class);
    }

}
