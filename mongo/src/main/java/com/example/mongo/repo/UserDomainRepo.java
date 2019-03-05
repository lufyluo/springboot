package com.example.mongo.repo;

import com.example.mongo.entity.UserEntity;

import java.util.List;

public interface UserDomainRepo {
    void addUsers(List<UserEntity> users);
}
