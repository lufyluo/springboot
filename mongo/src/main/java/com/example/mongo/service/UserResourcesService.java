package com.example.mongo.service;

import com.example.mongo.entity.UserResourcesEntity;

public interface UserResourcesService {
    int add(UserResourcesEntity us);

    int update(UserResourcesEntity us);

    int addResource(UserResourcesEntity us);
}
