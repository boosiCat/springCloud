package com.core.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cailiugen
 * @Date 2019/12/12
 */
@RestController
@RequestMapping("/main")
public class CoreMainController {

    @RequestMapping("/getById")
    public String getById(String str){
        System.out.println("-----CORE DO-----");
        return str;
    }
}
