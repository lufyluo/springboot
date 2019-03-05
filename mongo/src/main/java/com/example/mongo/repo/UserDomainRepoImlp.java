package com.example.mongo.repo;

import com.example.mongo.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class UserDomainRepoImlp implements UserDomainRepo {
    @Autowired
    private UserRepo userRepo;

    @Transactional()
    public void addUsers(List<UserEntity> users) {
        for (UserEntity userEntity : users) {
            if (StringUtils.isEmpty(userEntity.getUserName())) {
                throw new RuntimeException("fck off!");
            }
            userRepo.save(userEntity);
        }
    }
}
