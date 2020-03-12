package com.cc.hystrix.controller;

import com.cc.util.R;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YL.huang
 * @date 03/09/2020
 */
@RestController
@RequestMapping("hystrix")
public class TestHystrixController {

    @HystrixCommand(fallbackMethod = "queryfallback", ignoreExceptions = {
            ArithmeticException.class
    })
    @RequestMapping("query.do")
    public R query() throws InterruptedException {
        Thread.sleep(7000);
        System.out.println(1 / 0);
        return R.success("hystrix query success");
    }

    public R queryfallback() {
        return R.error("网络异常");
    }

}
