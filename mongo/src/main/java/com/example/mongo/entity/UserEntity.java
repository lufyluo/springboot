package com.example.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.UUID;

@Document(collection = "database_user")
public class UserEntity implements Serializable {
//    private static final long serialVersionUID = -3258839839160856613L;
//    @Transient
//    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private String id;
    @Field
    private String userName;
    @Field
    private String passWord;
    public UserEntity(){}
    public UserEntity(String userName,String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}