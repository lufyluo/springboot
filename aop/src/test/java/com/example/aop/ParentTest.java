package com.example.aop;

import com.example.aop.bean.ParentBean;
import com.example.aop.bean.SonBean;
import org.junit.Test;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/24
 */
public class ParentTest {
    @Test
    public void bTest() {
        SonBean sonBean = new SonBean();
        sonBean.setName("lufy");
        sonBean.setNick("luo");
        ParentBean parentBean = transP(sonBean);
        System.out.println(parentBean.getName());

        SonBean newSon = transS(parentBean);
        System.out.println(newSon.getNick());

        ParentBean parentBean11 = new ParentBean();
        SonBean sonBean1 = (SonBean) parentBean;
        System.out.println(sonBean1.getName());
    }

    @Test
    public void nullTest(){
        SonBean sonBean = null;
        if(sonBean ==null||sonBean.getNick()==null){
            System.out.println("fck");
        }
    }


    @Test
    public void parentMapTest2(){
        List<? extends ParentBean> listP = new ArrayList<>();
        List<? super ParentBean> listP2 = new ArrayList<>();
        List<ParentBean> listP3 = new ArrayList<>();
        //listP.add(new SonBean());
        listP2.add(new SonBean());
    }


    private ParentBean transP(SonBean sonBean) {
        return (ParentBean) sonBean;
    }

    private SonBean transS(ParentBean parentBean) {
        return (SonBean) parentBean;
    }
}
