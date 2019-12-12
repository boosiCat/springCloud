package com.core.client;

import com.common.base.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 调用user-service服务
 */
@FeignClient(value = "${feign.name.user-service}")
public interface UserServiceFeignClient {

    @GetMapping(value = "/getById")
    JsonResult getById(String id);
}
