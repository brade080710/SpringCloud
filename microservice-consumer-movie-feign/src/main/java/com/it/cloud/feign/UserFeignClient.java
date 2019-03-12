package com.it.cloud.feign;

import com.it.cloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") int id);
}
