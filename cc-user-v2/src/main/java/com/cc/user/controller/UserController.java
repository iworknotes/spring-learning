package com.cc.user.controller;

import com.cc.power.service.PowerService;
import com.cc.util.R;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YL.huang
 * @date 03/11/2020
 */
@RestController
@RequestMapping("v2")
public class UserController {

    @Autowired
    private PowerService powerService;

    /**
     * <p> Hystrix默认一个类为一个线程池，设置threadPool的作用-类似"舱壁模式"。防止某个方法有问题占用大量线程，导致其它方法无法访问
     * <p> 3秒钟内，请求失败数达到2个，并且失败率在50%以上，断路器打开；断路器打开后的活动窗口设置为3秒
     * <p> 配置@HystrixCommand的相关属性可以到HystrixCommandProperties类中去查找name
     *
     * @param userId
     * @return
     */
    @HystrixCommand(
            fallbackMethod = "getUserPowerFallback",
            threadPoolKey = "getUserPowerPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"), // 核心线程数
                    @HystrixProperty(name = "maxQueueSize", value = "10")// 线程队列数
            },
            commandProperties = {
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "3000"),// 窗口时间
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),// 最大请求失败数
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),// 跳闸失败率
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000"),// 跳闸后再次重试时间间隔

            })
    @RequestMapping("getUserPower")
    public R getUserPower(Integer userId) {
        return powerService.getPower(userId);
    }

    @HystrixCommand(fallbackMethod = "getUserPowerTimeOutFallback")
    @RequestMapping("getUserPowerTimeOut")
    public R getUserPowerTimeOut() {
        return powerService.getPowerTimeOut();
    }

    @HystrixCommand(fallbackMethod = "getUserPowerErrorFallback")
    @RequestMapping("getUserPowerError")
    public R getUserPowerError() {
        return powerService.getPowerError();
    }

    public R getUserPowerFallback(Integer userId) {
        return R.error("getUserPower 失败");
    }

    public R getUserPowerTimeOutFallback() {
        return R.error("getUserPowerTimeOut 失败");
    }

    public R getUserPowerErrorFallback() {
        return R.error("getUserPowerError 失败");
    }


}
