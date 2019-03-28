package com.example.mongo.service;

import com.example.mongo.entity.UserResourceEntity;
import com.example.mongo.entity.UserResourcesEntity;
import com.example.mongo.repo.ShareRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserResourcesServiceImpl implements UserResourcesService {
    @Autowired
    private ShareRepo shareRepo;
    @Override
    public int add(UserResourcesEntity us) {
         shareRepo.save(us);
        return 1;
    }

    @Override
    public int update(UserResourcesEntity us) {
        shareRepo.save(us);
        return 0;
    }

    @Override
    public int addResource(UserResourcesEntity us) {
        UserResourcesEntity userResourcesEntity = shareRepo.findById(us.getId());
        if(userResourcesEntity ==null)
            return 0;
        if(userResourcesEntity.getUserResourceEntities() ==null)
            userResourcesEntity.setUserResourceEntities(new ArrayList<UserResourceEntity>());
        userResourcesEntity.getUserResourceEntities().addAll(us.getUserResourceEntities());
        shareRepo.save(userResourcesEntity);
        return 0;
    }
}
