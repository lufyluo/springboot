package com.example.aop.bean;

import java.io.Serializable;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/10
 */
public class ParamVb implements Serializable {
    private static final long serialVersionUID = 4L;
    private transient String name = "lufyVb";

    private String add="hello";
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}
