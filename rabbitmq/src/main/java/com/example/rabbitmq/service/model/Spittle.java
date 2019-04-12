package com.example.rabbitmq.service.model;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/4/12 15:33
 */
public class Spittle {
    private int id;
    private String msg;

    public Spittle(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Spittle{" +
                "id=" + id +
                ", message='" + msg + '\'' +
                '}';
    }
}
