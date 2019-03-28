package com.example.mongo.controller;

import com.example.mongo.entity.UserResourcesEntity;
import com.example.mongo.service.UserResourcesService;
import com.example.mongo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/us")
public class UserResourceController {
    @Autowired
    private UserResourcesService userService;

    @PostMapping("add")
    public int add(@RequestBody UserResourcesEntity us) {
        return userService.add(us);
    }
    @PostMapping("addResource")
    public int addResource(@RequestBody UserResourcesEntity us) {
        return userService.addResource(us);
    }
    @PostMapping("update")
    public int update(@RequestBody UserResourcesEntity us) {
        return userService.update(us);
    }
}
