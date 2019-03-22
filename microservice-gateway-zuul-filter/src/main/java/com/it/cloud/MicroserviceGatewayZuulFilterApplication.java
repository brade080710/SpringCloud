package com.it.cloud;

import com.it.cloud.filter.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * feign 默认集成了hystrix，只需要在配置文件中开启就行了
 * 访问  http://localhost:8040/microservice-provider-user/users/1
 *会看到以下log信息
 * com.it.cloud.filter.PreRequestLogFilter  : send GET request to http://localhost:8040/microservice-provider-user/users/1
 */

@SpringBootApplication
@EnableZuulProxy
public class MicroserviceGatewayZuulFilterApplication {


    public static void main(String[] args) {
        SpringApplication.run(MicroserviceGatewayZuulFilterApplication.class, args);
    }

    @Bean
    public PreRequestLogFilter preRequestLogFilter() {
        return new PreRequestLogFilter();
    }

}
