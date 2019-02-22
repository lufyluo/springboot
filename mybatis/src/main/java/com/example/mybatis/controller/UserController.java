package com.example.mybatis.controller;

import com.example.mybatis.bean.User;
import com.example.mybatis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @PostMapping("add")
    public int add(@RequestBody User user) {
        return userService.add(user);
    }

    @PostMapping("batchAdd")
    public int add(@RequestBody List<User> users) {
        return userService.add(users);
    }
    @PostMapping("prepareData")
    public int prepareData(@RequestBody User user, @RequestParam int num) {
        return userService.prepareData(num,user);
    }
}
