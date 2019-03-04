package com.example.mongo.repo;

import com.example.mongo.entity.UserEntity;

import java.util.List;

public interface MongoRepo {
    void saveUser(UserEntity user);
    void saveUsers(List<UserEntity> user);
}
