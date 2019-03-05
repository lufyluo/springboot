package com.example.mongo.service;

import com.example.mongo.entity.UserEntity;
import com.example.mongo.repo.UserDomainRepo;
import com.example.mongo.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo mongoRepo;
    @Autowired
    private UserDomainRepo userDomainRepo;
    public void TransSaveUsers(){
        UserEntity user = new UserEntity("lufyfy","l87289610");
        UserEntity user1 = new UserEntity("","l87289610");

        UserEntity user2 = new UserEntity("lufyfy2","l87289610");
        List<UserEntity> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        userDomainRepo.addUsers(list);
    }
    public int save(UserEntity user){
        mongoRepo.save(user);
        return 1;
    }
}
