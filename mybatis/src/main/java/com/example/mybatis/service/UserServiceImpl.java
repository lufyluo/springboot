package com.example.mybatis.service;

import com.example.mybatis.bean.User;
import com.example.mybatis.dao.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public int prepareData(int num, User user) {
        user.setCreateTime(new Date());
        List<User> users = new ArrayList<User>(){};
        for (int i=0;i<num;i++){
            User userTemp= new User();
            userTemp.setName(user.getName()+i);
            users.add(userTemp);
        }
        return userRepo.prepareData(users);
    }

    @Override
    public int add(User user) {
        user.setCreateTime(new Date());
        return userRepo.insert(user);
    }

    @Override
    public int add(List<User> users) {
        return userRepo.batchInsert(users);
    }
}
