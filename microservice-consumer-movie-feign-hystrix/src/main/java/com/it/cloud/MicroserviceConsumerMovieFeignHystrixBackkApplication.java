package com.it.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * feign 默认集成了hystrix，只需要在配置文件中开启就行了
 */
@SpringBootApplication
@EnableFeignClients
public class MicroserviceConsumerMovieFeignHystrixBackkApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieFeignHystrixBackkApplication.class, args);
    }

}
