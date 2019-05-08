package com.example.aop;

import org.junit.Test;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/5/5 10:58
 */
public class EnumTest {
    @Test
    public void EnumCodeTest(){
        CarType carType = CarType.fromCode(1);
        System.out.println(carType.toString());
    }
}
