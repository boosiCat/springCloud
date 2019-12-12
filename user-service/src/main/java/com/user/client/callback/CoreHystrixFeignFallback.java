package com.user.client.callback;

import com.user.client.CoreServiceFeignClient;
import org.springframework.stereotype.Component;

/**
 * @Author cailiugen
 * @Date 2019/12/12
 */
@Component
public class CoreHystrixFeignFallback implements CoreServiceFeignClient {

    @Override
    public String getById(String id) {
        System.out.println("--------Hystrix----------");
        return null;
    }
}
