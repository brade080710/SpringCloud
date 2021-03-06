package com.it.cloud.web;

import com.it.cloud.entity.User;
import com.it.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movies")
@RestController
public class UserController {


    @Autowired
    private UserFeignClient userFeignClient;


    @GetMapping("/users/{id}")
    public User findById(@PathVariable int id) {
//
//        // 这里用到了RestTemplate的占位符能力
//        User user = this.restTemplate.getForObject("http://localhost:8081/users/{id}", User.class, id);
//        // ...电影微服务的业务...
//        return user;
        return this.userFeignClient.findById(id);


    }
}
