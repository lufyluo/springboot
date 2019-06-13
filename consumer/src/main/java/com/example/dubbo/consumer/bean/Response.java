package com.example.dubbo.consumer.bean;

import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Optional;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/12
 */
public class Response<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    @Nullable
    private final T data;


    public Response(@Nullable T data, Integer code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

}
