package com.example.aop.controller;

import com.example.aop.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    UserService userService;
    @GetMapping("/getInt")
    public int getInt(@RequestParam int id) {
        return userService.getInt(id);
    }
    @GetMapping("/getInt2")
    public int getInt2(@RequestParam int id) {
        return userService.getInt2(id);
    }
}
