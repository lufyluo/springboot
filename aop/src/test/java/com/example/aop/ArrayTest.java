package com.example.aop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/5/6 17:50
 */
public class ArrayTest {
    @Test
    public void setToList(){
        Object aa ="aa";
        Object bb ="bb";
        Object cc ="bb";
        Object in = 1;
        //List转Set
        Set<String> set = new HashSet<>();
        set.add(aa.toString());
        set.add(bb.toString());
        set.add(cc.toString());
        System.out.println("set: " + set);
        System.out.println((1+"").equals(in+""));
//Set转List
        List<String> list_1 = new ArrayList<>(set);
        System.out.println("list_1: " + list_1);
        System.out.println(null+"");
        list_1.contains(aa);
    }
    @Test
    public void listTest(){
        List<String> arr = new ArrayList<>();
        for (String info :
                arr) {
            System.out.println(info.toLowerCase());
        }
    }
    @Test
    public void listContainsTest(){
        List<String> arr = new ArrayList<>();
        arr.add("11111");
        Object obj = 11111;
        System.out.println(arr.contains(obj+""));
    }
}
