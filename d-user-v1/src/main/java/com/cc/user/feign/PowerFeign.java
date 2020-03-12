package com.cc.user.feign;

import com.cc.power.api.PowerAPI;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author YL.huang
 * @date 03/12/2020
 */
//@FeignClient(value = "d-power", fallback = PowerFeignFallback.class)
@FeignClient(value = "d-power", fallbackFactory = PowerFeignFallbackFactory.class)
public interface PowerFeign extends PowerAPI {
}
