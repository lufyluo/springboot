package com.example.redistemplate.bean;

import java.io.Serializable;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/21
 */
public class DataConf implements Serializable {
    private String key;
    private String group;
    private String val;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
