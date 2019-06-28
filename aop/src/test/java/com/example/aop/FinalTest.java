package com.example.aop;

import com.example.aop.bean.ParamV;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/19
 */
public class FinalTest {
    private final ParamV paramV;

    private final int va = 10;

    public FinalTest(){
        paramV = new ParamV();
    }
    @Test
    public void refTest(){
        paramV .setName("aa");
        System.out.println(paramV.getName());
//        Vector;
//        ArrayList;
//        BlockingQueue;
//        LinkedBlockingQueue
        ConcurrentMap concurrentMap = new ConcurrentHashMap();
    }
}
