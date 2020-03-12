package com.cc.power.controller;

import com.cc.power.api.PowerAPI;
import com.cc.util.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YL.huang
 * @date 03/06/2020
 */
@RestController
public class PowerController implements PowerAPI {

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @Override
    public R getPower(Integer userId) {
        System.out.println(instanceId + " doing getPower");
        Map map = new HashMap();
        map.put("powerName", "admin");
        return R.success(instanceId + " 查询成功", map);
    }

    @Override
    public R getPowerTimeOut() {
        System.out.println(instanceId + " doing getPowerTimeOut");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return R.success(instanceId + " getPowerTimeOut 查询超时");
    }

    @Override
    public R getPowerError() {
        System.out.println(instanceId + " doing getPowerError");
        return R.success(instanceId + " getPowerError 查询失败");
    }

}
