package com.example.mongo.service;

import com.example.mongo.entity.UserEntity;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = new UserService();

    @Test
    public void saveTest() {
        UserEntity user = new UserEntity("lufy", "l87289610");
        userService.save(user);
    }


}