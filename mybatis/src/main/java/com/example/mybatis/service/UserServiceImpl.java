package com.example.mybatis.service;

import com.example.mybatis.bean.User;
import com.example.mybatis.dao.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public int prepareData(int num, User user) {
        return userRepo.prepareData(num,user);
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
