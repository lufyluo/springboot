package com.example.mybatis.service;

import com.example.mybatis.bean.User;
import com.example.mybatis.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/7/4
 */
@Service
public class UserServiceFatherImpl extends UserServiceFather {
    @Autowired
    private UserRepo userRepo;

    @Override
    public int add1(User user) {
        user.setCreateTime(new Date());
        System.out.println("id: " + user.getId());
        int result = userRepo.insert(user);
        System.out.println(user.getId());
        if (user.getId() > 0)
            throw new NullPointerException();
        return result;
    }


}
