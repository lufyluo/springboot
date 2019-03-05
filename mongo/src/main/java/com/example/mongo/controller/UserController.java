package com.example.mongo.controller;

import com.example.mongo.entity.UserEntity;
import com.example.mongo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int add(@RequestBody UserEntity userEntity){
        return userService.save(userEntity);
    }
}
