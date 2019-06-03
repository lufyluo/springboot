package com.example.mybatis.bean;

public enum SexEnum implements BaseEnum{
    MAN(0, "男"), WOMAN(1, "女");

    private int key;
    private String value;

    /**
     * 私有化构造函数
     *
     * @param key
     * @param value
     */
    private SexEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     *
     * @Title: getSexEnumByKey
     * @Description: 依据key获取枚举
     * @param key
     * @return
     */
    public static SexEnum getSexEnumByKey(int key) {
        for (SexEnum item : values()) {
            if (item.getKey() == key) {
                return item;
            }
        }
        return null;
    }
    @Override
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public String toString(){
        return this.key+"";
    }
}
