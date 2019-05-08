package com.example.aop;

import org.junit.Test;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/5/5 15:26
 */
public class DoubleTest {
    @Test
    public void doubleToFloatTest(){
        Double d = 2.35d;
        System.out.println((float)d.doubleValue());
        float f = 1.356865323256f;
        System.out.println((double)f);
    }
}
