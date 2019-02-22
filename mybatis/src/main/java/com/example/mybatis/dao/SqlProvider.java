package com.example.mybatis.dao;

import com.example.mybatis.bean.User;

import java.util.Map;

public class SqlProvider {
    public String prepareData(Map<String, Object> para) {
        User user = (User) para.get("user");
        StringBuilder stringBuilder = new StringBuilder("insert into user (name, createTime) values (#name, #createTime)");
        int num = (Integer) para.get("num");
        for (int i =0;i<num;i++){
            stringBuilder.append("(#name, #createTime)");
        }
        return stringBuilder.toString();
    }
}
