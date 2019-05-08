package com.example.aop;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/28 15:18
 */
public class DateTimeTest {
    @Test
    public void longToDateStringTest(){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1481286139000l));
        System.out.println(date);
    }
    @Test
    public void DateToLongTest() throws ParseException {
        String dateO = "1970-01-01 00:00:00";
        Date date =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateO);
        System.out.println(date.getTime());
    }
}
