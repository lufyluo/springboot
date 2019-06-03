package com.example.aop;

import com.example.aop.bean.ParamV;
import org.junit.Test;
import org.springframework.util.Assert;
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
    @Test
    public void StringToInt(){
        ParamV v= new ParamV();
        String str = "61.92";
        Double a = Double.parseDouble(str);
        int te = 10;
        te+=a;
        System.out.println(te);
    }
    @Test
    public void StringFormatTest(){
       String tr = String.format("%s%s%s",1,2,3);
        System.out.println(tr);
        Assert.isTrue(!StringUtils.isEmpty(tr),"aaa");
    }

}
