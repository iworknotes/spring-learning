package com.cc.user.feign;

import com.cc.util.R;
import org.springframework.stereotype.Component;

/**
 * @author YL.huang
 * @date 03/12/2020
 */
//@Component
public class PowerFeignFallback implements PowerFeign {
    @Override
    public R getPower(Integer userId) {
        return R.error("getPower 失败");
    }

    @Override
    public R getPowerTimeOut() {
        return R.error("getUserPowerTimeOut 失败");
    }

    @Override
    public R getPowerError() {
        return R.error("getPowerError 失败");
    }
}
