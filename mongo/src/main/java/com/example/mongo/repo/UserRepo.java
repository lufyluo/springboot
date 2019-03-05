package com.example.mongo.repo;

import com.example.mongo.entity.UserEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserEntity, Long> {
}
