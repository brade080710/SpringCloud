package com.it.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * feign 默认集成了hystrix，只需要在配置文件中开启就行了
 */
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication

public class MicroserviceConsumerMovieFeignHystrixStreamApplication {


    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieFeignHystrixStreamApplication.class, args);
    }

}
