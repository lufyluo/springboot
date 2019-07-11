package com.example.mybatis.service;

import com.example.mybatis.bean.User;
import com.example.mybatis.dao.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public int prepareData(int num, User user) {
        user.setCreateTime(new Date());
        List<User> users = new ArrayList<User>() {
        };
        for (int i = 0; i < num; i++) {
            User userTemp = new User();
            userTemp.setName(user.getName() + i);
            users.add(userTemp);
        }
        return userRepo.prepareData(users);
    }

    @Override
    public int add(User user) {
        user.setCreateTime(new Date());
        System.out.println("id: " + user.getId());
        int result = userRepo.insert(user);
        System.out.println(user.getId());
        if (user.getId() > 0)
            throw new NullPointerException();
        return result;
    }


    @Override
    @Transactional
    public int addAndUpdate(User user) {
        user.setCreateTime(new Date());
        int result = userRepo.insert(user);
        System.out.println(user.getId());
        return result;
    }

    @Override
    public int add(List<User> users) {
        return userRepo.batchInsert(users);
    }
}
