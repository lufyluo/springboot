package com.example.aop.controller;

import com.example.aop.bean.PojoUser;
import com.example.aop.bean.UserInfo;
import com.example.aop.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/getPojo")
    public PojoUser getPojo(@RequestBody @Validated UserInfo userInfo){

        return null;
       // return userService.toPojoUser(userInfo);
    }

    @GetMapping("/get/bool/{bool}")
    public boolean getBool(@PathVariable int bool){
        return userService.getBool(bool);
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable int id){
        return id;
    }

}
