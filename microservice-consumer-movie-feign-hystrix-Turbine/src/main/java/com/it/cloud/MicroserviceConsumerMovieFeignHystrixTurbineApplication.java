package com.it.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Tubine即可聚合microservice-consumer-movie,microservice-consumer-movie-feign两个服务的/actuator/hystrix.stream 信息，
 * 并暴露在http://localhost:8031/turbine.stream ，将该地址贴到Hystrix Dashboard上，即可看到类似如下的图表：
 */
@SpringBootApplication
@EnableTurbine
public class MicroserviceConsumerMovieFeignHystrixTurbineApplication {


    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieFeignHystrixTurbineApplication.class, args);
    }

}
