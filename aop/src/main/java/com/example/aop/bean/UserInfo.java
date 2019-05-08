package com.example.aop.bean;

import java.util.Date;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/23 15:34
 */
public class UserInfo {
    private String name;
    private int age;
    private Address address;
    private Date createTime;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
