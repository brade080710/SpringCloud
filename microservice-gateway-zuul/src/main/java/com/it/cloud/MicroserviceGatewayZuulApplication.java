package com.it.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * feign 默认集成了hystrix，只需要在配置文件中开启就行了
 */

@SpringBootApplication
@EnableZuulProxy
public class MicroserviceGatewayZuulApplication {


    public static void main(String[] args) {
        SpringApplication.run(MicroserviceGatewayZuulApplication.class, args);
    }

}
