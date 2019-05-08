package com.example.aop.bean;

import java.util.Date;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/23 15:35
 */
public class Address {
    private String address;
    private String no;
    private Date createTime;
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
