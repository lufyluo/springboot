package com.example.mybatis.service;

import com.example.mybatis.bean.User;

import java.util.List;

public interface UserService {
    int prepareData(int num, User user);

    int add(User user);

    int add(List<User> users);
}
