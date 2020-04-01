package com.cc.ribbon;

import config.PowerRibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * Ribbon测试
 * <p> @RibbonClient为不同的客户端配置不同的轮询策略
 *
 * @author YL.huang
 * @date 03/08/2020
 */
@RibbonClients({
        @RibbonClient(name = "D-POWER", configuration = PowerRibbonConfiguration.class)
})
@EnableEurekaClient
@SpringBootApplication
public class TestRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRibbonApplication.class, args);
    }

}
