package com.example.mongo.service;

import com.example.mongo.entity.UserEntity;
import com.example.mongo.repo.MongoRepo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    @Autowired
    private MongoRepo mongoRepo;
    public void TransSaveUsers(){
        UserEntity user = new UserEntity("lufy","l87289610");
        UserEntity user1 = new UserEntity("","l87289610");

        UserEntity user2 = new UserEntity("lufy2","l87289610");
        List<UserEntity> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        mongoRepo.saveUsers(list);
    }
    public void save(UserEntity user){
        mongoRepo.saveUser(user);
    }
}
