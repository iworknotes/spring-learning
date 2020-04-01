package com.cc.power.service;

import com.cc.power.constant.PowerRequestURL;
import com.cc.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author YL.huang
 * @date 03/11/2020
 */
@Service
public class PowerService {

    @Autowired
    private RestTemplate restTemplate;

    public R getPower(Integer userId) {
        return restTemplate.getForObject(PowerRequestURL.INSTANCE_URL + PowerRequestURL.GET_POWER, R.class);
    }

    public R getPowerTimeOut() {
        return restTemplate.getForObject(PowerRequestURL.INSTANCE_URL + PowerRequestURL.GET_POWER_TIMEOUT, R.class);
    }

    public R getPowerError() {
        return restTemplate.getForObject(PowerRequestURL.INSTANCE_URL + PowerRequestURL.GET_POWER_ERROR, R.class);
    }

}
