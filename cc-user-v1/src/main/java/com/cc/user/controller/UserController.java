package com.cc.user.controller;

import com.cc.entity.UserEntity;
import com.cc.user.feign.PowerFeign;
import com.cc.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YL.huang
 * @date 03/12/2020
 */
@RestController
@RequestMapping("v1")
public class UserController {

    @Autowired
    private PowerFeign powerFeign;

    @GetMapping("getUserPower")
    public R getUserPower(Integer userId) {
        return powerFeign.getPower(userId);
    }

    @RequestMapping("getUserPowerTimeOut")
    public R getUserPowerTimeOut() {
        return powerFeign.getPowerTimeOut();
    }

    @GetMapping("getUserPowerV2")
    public R getUserPowerV2(@RequestBody UserEntity user) {
        System.out.println(user);
        return powerFeign.getPowerByUser(user);
    }

}
