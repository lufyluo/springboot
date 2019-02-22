package com.example.aop.service;

import com.example.aop.aop.InvokeException;
import com.example.aop.aop.LogAnnotation;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
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
}