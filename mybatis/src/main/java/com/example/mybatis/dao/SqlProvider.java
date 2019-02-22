package com.example.mybatis.dao;

import com.example.mybatis.bean.User;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class SqlProvider {
    public String prepareData(Map<String, Object> para) {
        List<User> user = (List<User>) para.get("users");
        StringBuilder stringBuilder = new StringBuilder("insert into user (name, createTime) values");
        int num = user.size();
        MessageFormat mf = new MessageFormat("( #'{'users[{0}].name}, #'{'users[{0}].createTime})");
        for (int i =0;i<num;i++){
            stringBuilder.append(mf.format(new Object[]{i}));
            if(i<num-1){
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }
}
