package com.cc.power;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author YL.huang
 * @date 03/06/2020
 */
@EnableEurekaClient
@SpringBootApplication
public class PowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PowerApplication.class);
    }

}
