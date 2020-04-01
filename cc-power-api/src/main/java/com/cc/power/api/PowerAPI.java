package com.cc.power.api;

import com.cc.entity.UserEntity;
import com.cc.power.constant.PowerRequestURL;
import com.cc.util.R;
//import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * power服务API
 *
 * @author YL.huang
 * @date 03/11/2020
 */
public interface PowerAPI {

    //    @PostMapping(PowerRequestURL.GET_POWER)
    @GetMapping(PowerRequestURL.GET_POWER)
    R getPower(@RequestParam("userId") Integer userId);

    @RequestMapping(PowerRequestURL.GET_POWER_TIMEOUT)
    R getPowerTimeOut();

    @RequestMapping(PowerRequestURL.GET_POWER_ERROR)
    R getPowerError();

    @GetMapping(value = PowerRequestURL.GET_POWER_BY_USER, consumes = MediaType.APPLICATION_JSON_VALUE)
    R getPowerByUser(@RequestBody UserEntity user);

}
