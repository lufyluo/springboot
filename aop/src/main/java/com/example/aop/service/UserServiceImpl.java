package com.example.aop.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.aop.aop.LogAnnotation;

import com.example.aop.bean.PojoUser;
import com.example.aop.bean.UserInfo;
import com.example.aop.util.PojoMapper;
import org.springframework.stereotype.Service;
import service.bean.InvokeException;

@Service
public class UserServiceImpl implements UserService {
    @Reference
    private service.UserService userService;

    @LogAnnotation
    @Override
    public int getInt(int id) {
        if(id ==0)
            throw new RuntimeException("gggg");
        if(id==-1)
            throw new InvokeException(233,"invoke","my");
        return 10;
    }

    @Override
    public int getInt2(int id) {
        if(id ==0)
            throw new RuntimeException("gggg");
        if(id==-1)
            throw new InvokeException(233,"invoke","my");
        return 5;
    }

    @Override
    public PojoUser toPojoUser(UserInfo user) {
        return PojoMapper.INSTANCE.toPojoUser(user);
    }

    public boolean getBool(int channel){
        return userService.getBool(channel);
    }
}
