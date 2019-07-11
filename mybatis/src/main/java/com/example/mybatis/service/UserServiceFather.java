package com.example.mybatis.service;

import com.example.mybatis.bean.User;
import com.example.mybatis.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/7/4
 */

public abstract class UserServiceFather {
    @Autowired
    private UserRepo userRepo;
    @Transactional()
    public int addU(User user){
        return midF(user);
    }
    public int midF(User user){
        return add1(user);
    }

    public abstract int add1(User user);
}
