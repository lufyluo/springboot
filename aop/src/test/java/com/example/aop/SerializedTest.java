package com.example.aop;

import com.alibaba.fastjson.JSON;
import com.example.aop.bean.ParamV;
import com.example.aop.bean.ParamVb;
import org.junit.Test;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/10
 */
public class SerializedTest {
    @Test
    public void seriTest(){
        ParamV p = new ParamV();
        //p.setName("lufy");
        System.out.println(JSON.toJSONString(p));
        byte[] re = JSON.toJSONBytes(p);
        String jsonStr = JSON.toJSONString(p);
        ParamVb paramVb = JSON.parseObject(jsonStr,ParamVb.class);
        ParamVb paramVbBytye  = JSON.parseObject(re,ParamVb.class);
        System.out.println(paramVb.getName());
    }
    @Test
    public void ObjTest(){
        ParamV p = new ParamV();
        strAdd(p.getName());
        System.out.println(p.getName());
        String a = "a";
        strAdd(a);
        System.out.println(a);
        strAdd(p);
        System.out.println(p.getName());
    }
    private void strAdd(String param){
        param = "b";
    }
    private void strAdd(ParamV param){
        param.setName("b");
    }
}
