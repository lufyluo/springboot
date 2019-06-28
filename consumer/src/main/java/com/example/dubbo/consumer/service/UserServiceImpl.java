package com.example.dubbo.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/6
 */
@Service
public class UserServiceImpl implements UserPortalService{
    @Reference
    private UserService userService;
    @Override
    public int get(){
        return userService.test();
    }
}
