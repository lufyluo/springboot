package com.example.mongo.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

public class UserResourceEntity {
    @Id
    private String id;
    private int sharerId;
    private Date createDate;
    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSharerId() {
        return sharerId;
    }

    public void setSharerId(int sharerId) {
        this.sharerId = sharerId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
