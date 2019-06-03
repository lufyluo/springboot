package com.example.aop;

import com.example.aop.bean.ParamV;
import org.junit.Test;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/5/27
 */
public class IntegerTest {
    Object obj = null;

    @Test
    public void NullIntTest() {
        Integer a = (Integer) obj;
        if (a != null && a > 0) {
            System.out.println("nice");
        } else {
            System.out.println("bad");
        }
    }
}
