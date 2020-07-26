package com.example.myserviceconsumerclient.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "myService-provider-user")
@Component
public interface UserFeignClient {

    @RequestMapping(value = "/base/info",method = RequestMethod.GET)
    String  info();
}
