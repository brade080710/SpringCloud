package com.it.cloud.web;

import com.it.cloud.dao.UserMapper;
import com.it.cloud.entity.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {

        logger.info("ribbon1");

        return userMapper.selectByPrimaryKey(id);
    }
}
