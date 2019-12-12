package com.user.web;

import com.user.client.CoreServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cailiugen
 * @Date 2019/12/12
 */
@RestController
@RequestMapping("/main")
public class UserMainController {

    @Autowired
    CoreServiceFeignClient coreServiceFeignClient;

    @RequestMapping("/test")
    public String test() {
        System.out.println("-----USER DO-----");
        return coreServiceFeignClient.getById("测试");
    }
}
