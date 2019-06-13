package com.example.dubbo.consumer.controller;

import com.example.dubbo.consumer.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/6
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @GetMapping("get")
    public int get(){
        return userServiceImpl.get();
    }
}
