package com.example.mybatis.dao;

import com.example.mybatis.bean.User;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SqlProviderTest {
private SqlProvider sqlProvider = new SqlProvider();
    @Test
    public void prepareData() {
        Map<String,Object> map= new HashMap<>();
        User user = new User();
        user.setName("lufy");
        map.put("user",user);
        String str = sqlProvider.prepareData(map);
    }
}