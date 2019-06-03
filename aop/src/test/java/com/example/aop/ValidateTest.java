package com.example.aop;

import com.example.aop.bean.ParamV;
import org.junit.Test;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/5/25
 */
public class ValidateTest {
    @Test
    public void test(){
        ParamV paramV = new ParamV();
        cal(paramV);
    }
    public void cal(@Valid ParamV paramV){
        System.out.println(paramV.getName());
    }
}
