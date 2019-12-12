package com.user.client;

import com.user.client.callback.CoreHystrixFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 调用core-service服务
 */
@FeignClient(value = "${feign.name.core-service}", fallback = CoreHystrixFeignFallback.class)
public interface CoreServiceFeignClient {

    @GetMapping(value = "/main/getById")
    String getById(String id);

}
