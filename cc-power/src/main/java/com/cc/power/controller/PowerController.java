package com.cc.power.controller;

import com.cc.entity.UserEntity;
import com.cc.power.api.PowerAPI;
import com.cc.util.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
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
        System.out.println(instanceId + " doing getPower,userId=" + userId);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        return R.success(instanceId + " getPowerTimeOut 成功");
    }

    @Override
    public R getPowerError() {
        System.out.println(instanceId + " doing getPowerError");
        return R.success(instanceId + " getPowerError 成功");
    }

    @Override
    public R getPowerByUser(UserEntity user) {
        System.out.println(instanceId + " doing getPowerByUser, user=" + user);
        Map map = new HashMap();
        map.put("userName", user.getName());
        map.put("power", "sup-admin");
        return R.success(instanceId + " getPowerByUser 成功", map);
    }

}
