package com.example.aop.service;

import com.example.aop.bean.PojoUser;
import com.example.aop.bean.UserInfo;

public interface UserService {
    int getInt(int id);
    int getInt2(int id);
    PojoUser toPojoUser(UserInfo user);
    boolean getBool(int channel);
}
