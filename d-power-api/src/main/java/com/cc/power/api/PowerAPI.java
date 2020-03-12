package com.cc.power.api;

import com.cc.power.constant.PowerRequestURL;
import com.cc.util.R;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * power服务API
 *
 * @author YL.huang
 * @date 03/11/2020
 */
public interface PowerAPI {

    @RequestMapping(PowerRequestURL.GET_POWER)
    R getPower(Integer userId);

    @RequestMapping(PowerRequestURL.GET_POWER_TIMEOUT)
    R getPowerTimeOut();

    @RequestMapping(PowerRequestURL.GET_POWER_ERROR)
    R getPowerError();

}
