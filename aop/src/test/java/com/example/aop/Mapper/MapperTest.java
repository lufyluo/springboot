package com.example.aop.Mapper;

import com.example.aop.bean.Address;
import com.example.aop.bean.UserInfo;
import com.example.aop.bean.UserInfoVo;
import com.example.aop.mapper.PojoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/5/5 11:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    @Test
    public void mapperTest1(){
        UserInfo userInfo = new UserInfo();
        Address address = new Address();
        userInfo.setName("lufy");
        userInfo.setAge(20);
        userInfo.setAddress(null);
        userInfo.setCreateTime(new Date());
        address.setNo("220");
        address.setAddress("tianMa");
        address.setCreateTime(new Date());
        UserInfoVo userInfoVo = PojoMapper.INSTANCE.getUserInfo(userInfo);
        //System.out.println(userInfo.getAddress().getAddress());
        Long a = 10001l;
        System.out.println(a.toString());
    }

}
