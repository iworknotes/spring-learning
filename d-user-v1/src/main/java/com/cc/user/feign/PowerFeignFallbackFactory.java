package com.cc.user.feign;

import com.cc.entity.UserEntity;
import com.cc.util.R;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author YL.huang
 * @date 03/12/2020
 */
@Component
public class PowerFeignFallbackFactory implements FallbackFactory<PowerFeign> {
    @Override
    public PowerFeign create(Throwable throwable) {
        return new PowerFeign() {
            @Override
            public R getPower(Integer userId) {
                return R.error("getPower 跳闸 " + throwable);
            }

            @Override
            public R getPowerTimeOut() {
                return R.error("getUserPowerTimeOut 跳闸 " + throwable);
            }

            @Override
            public R getPowerError() {
                return R.error("getPowerError 跳闸 " + throwable);
            }

            @Override
            public R getPowerByUser(UserEntity user) {
                return R.error("getPowerByUser 跳闸 " + throwable);
            }
        };
    }
}
