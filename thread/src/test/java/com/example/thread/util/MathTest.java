package com.example.thread.util;

import org.junit.Test;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/7/1
 */
public class MathTest {
    @Test
    public void IndinctTest(){
        int COUNT_BITS = Integer.SIZE - 3;
        int TERMINATED =  3 << COUNT_BITS;
        int RUNNING    = -1 << COUNT_BITS;
        int a = 2<<1;
        int RUNNNINGLAST = RUNNING | 0;
        System.out.println(COUNT_BITS + "-" +TERMINATED + "-" + RUNNING+"-" + a+"-" + RUNNNINGLAST);
    }
}
