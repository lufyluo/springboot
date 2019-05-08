package com.example.aop;

public enum CarType {
    STARTINGPRICE(0, "起步价",true,0),
    DISTANCEPRICE(1, "里程费",true,100),
    TIMEPRICE(2, "时长费",true,200);
    private int code;
    private String name;
    private boolean show;
    private int sort;

    CarType(int i, String 时长费, boolean b, int i1) {
        this.code = code;
        this.name = name;
        this.show=show;
        this.sort=sort;
    }
    public static CarType fromCode(int code) {

        for(CarType item:values()) {
            if(item.code == code) {
                return item;
            }
        }
        return STARTINGPRICE;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
