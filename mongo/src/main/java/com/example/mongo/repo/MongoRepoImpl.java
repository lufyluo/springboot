package com.example.mongo.repo;

import com.example.mongo.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class MongoRepoImpl implements MongoRepo{
    @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * 创建对象
     * @param user
     */
    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    @Override
    @Transactional
    public void saveUsers(List<UserEntity> users) {
        for(UserEntity userEntity:users){
            if(StringUtils.isEmpty(userEntity.getUserName()))
                throw new RuntimeException("fck off");
            mongoTemplate.save(userEntity);
        }
    }
}
