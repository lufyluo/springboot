package com.example.aop;

import org.springframework.util.StringUtils;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/5/6 17:45
 */
public class StringTest
{
    public void StringNullTest(){
        Object aa=null;
        String aaStr = (String)aa;
        System.out.println(StringUtils.isEmpty(aaStr));

    }
}
