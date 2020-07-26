package com.example.myserviceconsumerclient.controller;

import com.example.myserviceconsumerclient.feignclient.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserFeignClient userFeignClient;

    @ResponseBody
    @RequestMapping(value = "/base/info")
    @HystrixCommand(fallbackMethod = "infoBack")
    public String testFeign(){
        String str  = userFeignClient.info();
        return str;
    }

    public String infoBack(){
        return "go back";
    }

    @Value("${profile}")
    private String profile;

    @ResponseBody
    @RequestMapping("/profile")
    public String hello(){
        return this.profile;
    }

}
