package com.example.mongo.service;

import com.example.mongo.entity.UserEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void saveTest() {
        UserEntity user = new UserEntity("lufy1", "l87289610");
        userService.save(user);
    }

    @Test
    public void saveUsersTest() {
        userService.TransSaveUsers();
    }

}