package com.example.aop;

import com.example.aop.bean.ParentBean;
import com.example.aop.bean.SonBean;
import com.example.aop.bean.SonBean1;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
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
    private static final Unsafe unsafe;

    static {
        Unsafe unsafe1 = null;
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe1 = (Unsafe)field.get(null);
        } catch (Exception e) {

        }
        unsafe = unsafe1;
    }

    @Test
    public void bTest() {
        SonBean sonBean = new SonBean();
        sonBean.setName("lufy");
        sonBean.setNick("luo");
        ParentBean parentBean = transP(sonBean);
        SonBean1 sonBeant1 = (SonBean1)parentBean;

        System.out.println(parentBean.getName());

        SonBean newSon = transS(parentBean);
        System.out.println(newSon.getNick());
        ParentBean parentBean11 = new ParentBean();
        SonBean sonBean1 = (SonBean) parentBean11;
        System.out.println(sonBean1.getName());
    }

    @Test
    public void nullTest() {
        SonBean sonBean = null;
        if (sonBean == null || sonBean.getNick() == null) {
            System.out.println("fck");
        }
    }


    @Test
    public void parentMapTest2() {
        List<? extends ParentBean> listP = new ArrayList<>();
        List<? super ParentBean> listP2 = new ArrayList<>();
        List<ParentBean> listP3 = new ArrayList<>();
        //listP.add(new SonBean());
        listP2.add(new SonBean());
    }

    @Test
    public void mapTest() {
        ParentBean parentBean = new ParentBean();
        parentBean.setName("a");
        Map<Integer, ParentBean> map = new HashMap<>();
        map.put(0, parentBean);
        parentBean.setName("b");
        System.out.println(parentBean.getName());
    }

    @Test
    public void privateTest(){
        ParentBean parentBean = new ParentBean();
        System.out.println(parentBean.getPriName());
        Class<?> k = ParentBean.class;
        try {
            long offserOld =  unsafe.objectFieldOffset(k.getDeclaredField("priName"));
            unsafe.compareAndSwapObject(parentBean,offserOld,parentBean.getPriName(),"lufyO");
            System.out.println(parentBean.getPriName());
            //wait to continue;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    private ParentBean transP(SonBean sonBean) {
        return (ParentBean) sonBean;
    }

    private SonBean transS(ParentBean parentBean) {
        return (SonBean) parentBean;
    }
}
