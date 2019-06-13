package com.example.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import service.UserService;
import service.bean.InvokeException;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/3
 */
@Service
@Component
public class UserServiceImpl implements UserService {
    @Override
    public int test() {
        throw new NullPointerException();
        //return 0;
    }

    @Override
    public boolean getBool(int chanel) {
        if(chanel ==0)
            throw new InvokeException(500,"error");
        return chanel>10;
    }
}
