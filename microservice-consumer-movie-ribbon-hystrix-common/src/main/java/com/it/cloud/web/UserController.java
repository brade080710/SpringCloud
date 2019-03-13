package com.it.cloud.web;

import com.it.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/movies")
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/users/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User findById(@PathVariable Integer id) {

        // 这里用到了RestTemplate的占位符能力
        User user = this.restTemplate.getForObject("http://microservice-provider-user/users/{id}", User.class, id);
        // ...电影微服务的业务...
        return user;
    }


    public User findByIdFallback(Integer id,  Throwable throwable) {
        logger.info("进入回退方法", throwable);
        User user =new User();
        user.setAge(11);
        user.setName("test");
        user.setBalance(1l);
        user.setId(id);
        return user;
    }
}
