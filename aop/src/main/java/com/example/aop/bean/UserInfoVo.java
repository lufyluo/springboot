package com.example.aop.bean;

import java.util.Date;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/5/5 11:21
 */
public class UserInfoVo {
    private String nameVo;
    private int ageVo;
    private AddressVo addressVo;
    private String createTimeVo;
    public String getNameVo() {
        return nameVo;
    }

    public void setNameVo(String nameVo) {
        this.nameVo = nameVo;
    }

    public int getAgeVo() {
        return ageVo;
    }

    public void setAgeVo(int ageVo) {
        this.ageVo = ageVo;
    }

    public AddressVo getAddressVo() {
        return addressVo;
    }

    public void setAddressVo(AddressVo addressVo) {
        this.addressVo = addressVo;
    }

    public String getCreateTimeVo() {
        return createTimeVo;
    }

    public void setCreateTimeVo(String createTimeVo) {
        this.createTimeVo = createTimeVo;
    }
}
