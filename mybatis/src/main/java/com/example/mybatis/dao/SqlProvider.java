package com.example.mybatis.dao;

import com.example.mybatis.bean.User;

import java.text.MessageFormat;
import java.util.Map;

public class SqlProvider {
    public String prepareData(Map<String, Object> para) {
        User user = (User) para.get("user");
        StringBuilder stringBuilder = new StringBuilder("insert into user (name, createTime) values (#name, #createTime)");
        int num = (Integer) para.get("num");
        MessageFormat mf = new MessageFormat("( #'{'list[{0}].name}, #'{'list[{0}].createTime})");
        for (int i =0;i<num;i++){
            stringBuilder.append(mf.format(new Object[]{i}));
            if(i<num-1){
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }
}
