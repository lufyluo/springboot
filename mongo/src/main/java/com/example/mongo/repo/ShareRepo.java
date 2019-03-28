package com.example.mongo.repo;

import com.example.mongo.entity.UserResourcesEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ShareRepo extends MongoRepository<UserResourcesEntity, Long> {
    @Query("{'id':?0}")
     UserResourcesEntity findById(String id);
}
