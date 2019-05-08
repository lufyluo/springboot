package com.example.elk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ElkApplicationTests {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void test() throws Exception {

        for(int i=0;i<100;i++) {
            logger.info("输出info  " + i);
            logger.debug("输出debug+skkkw嗡嗡嗡kw " + i);
            logger.error("输出error  嗡嗡嗡我 " + i);
        }
    }
    @Test
    public void logTest() {
        long date =  new Date("2018-10-26 17:29:10").toInstant().getEpochSecond();
        System.out.println(date);
        logger.info("输出info  " + date);
        logger.debug("输出debug+skkkw嗡嗡嗡kw " + date);
        logger.error("输出error  嗡嗡嗡我 " + date);
    }

    @Test
    public void contextLoads() {
    }

}
