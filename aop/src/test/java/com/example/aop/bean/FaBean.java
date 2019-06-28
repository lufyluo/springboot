package com.example.aop.bean;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/25
 */
public class FaBean<T extends ParentBean>
{
    private T data;
    private String fa;

    public String getFa() {
        return fa;
    }

    public void setFa(String fa) {
        this.fa = fa;
    }
}
