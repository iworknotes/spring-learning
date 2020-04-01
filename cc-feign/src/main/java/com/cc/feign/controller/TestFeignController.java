package com.cc.feign.controller;

import com.cc.feign.service.PowerFeignService;
import com.cc.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Feign
 *
 * @author YL.huang
 * @date 03/09/2020
 */
@RestController
@RequestMapping("feign")
public class TestFeignController {

    @Autowired
    private PowerFeignService powerFeignService;

    @RequestMapping("query.do")
    public R query() {
        return R.success("feign query success", powerFeignService.getPower());
    }

}
