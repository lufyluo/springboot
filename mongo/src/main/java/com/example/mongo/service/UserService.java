package com.example.mongo.service;

import com.example.mongo.entity.UserEntity;

public interface UserService {
    void TransSaveUsers();
    int save(UserEntity user);
}
