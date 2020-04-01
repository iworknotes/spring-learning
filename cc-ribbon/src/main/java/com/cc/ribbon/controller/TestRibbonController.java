package com.cc.ribbon.controller;

import com.cc.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author YL.huang
 * @date 03/08/2020
 */
@RestController
@RequestMapping("ribbon")
public class TestRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    private final String POWER_URL = "http://D-POWER";

    /**
     * 开启 Ribbon 负载均衡后，就可以通过微服务的名字从 Eureka 中找到对应的服务
     *
     * @return
     */
    @RequestMapping("query.do")
    public R query() {
        System.out.println("ribbon do query.");
        return R.success("ribbon query success", restTemplate.getForObject(POWER_URL + "/getPower.do", Object.class));
    }

}
