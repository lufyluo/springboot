package com.example.aop.bean;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/24
 */
public class ParentBean {
    private String name;
    private String priName = "hello";
    private String nick;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriName() {
        return priName;
    }
}
