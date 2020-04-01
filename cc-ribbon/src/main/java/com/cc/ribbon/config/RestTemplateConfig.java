package com.cc.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置类
 *
 * @author YL.huang
 * @date 03/08/2020
 */
@Configuration
public class RestTemplateConfig {

    /**
     * LoadBalanced注解 表示使用Ribbon实现客户端负载均衡
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
