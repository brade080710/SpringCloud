package com.it.cloud.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// 访问进入 http://localhost:8030，将http://localhost:8020/actuator/hystrix.stream输入，就可以监控这个地址服务的情况
@Controller
public class HystrixIndexController {
    @GetMapping("")
    public String index() {
        return "forward:/hystrix";
    }
}