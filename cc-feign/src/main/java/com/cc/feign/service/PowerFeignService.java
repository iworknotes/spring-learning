package com.cc.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author YL.huang
 * @date 03/09/2020
 */
@FeignClient(name = "D-POWER")
public interface PowerFeignService {

    @RequestMapping("/getPower.do")
    Map getPower();

}
