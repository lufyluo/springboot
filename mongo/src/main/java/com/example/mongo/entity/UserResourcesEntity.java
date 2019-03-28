package com.example.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

@Document(collection = "userResources")
public class UserResourcesEntity {
    @Id
    private String id;
    @Field
    private int userId;
    @Field
    private int classId;
    @Field
    private List<UserResourceEntity> userResourceEntities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public List<UserResourceEntity> getUserResourceEntities() {
        return userResourceEntities;
    }

    public void setUserResourceEntities(List<UserResourceEntity> userResourceEntities) {
        this.userResourceEntities = userResourceEntities;
    }
}
