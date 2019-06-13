package com.example.aop.aop;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import service.bean.InvokeCode;
import service.bean.InvokeException;

public class InvokeResult<T> {

    /**
     * 是否成功
     *
     */
    @JsonProperty
    Boolean Success;

    /**
     * 错误码
     */
    @JsonProperty
    int Code ;

    /**
     * 结果信息
     */
    @JsonProperty
    String Message;

    /**
     * 操作描述
     */
    @JsonProperty
    String Description ;

    /**
     * 数据
     */
    @JsonProperty
    T Data ;

    @JsonIgnore
    public Boolean getSuccess() {
        return Success;
    }

    @JsonIgnore
    public void setSuccess(Boolean success) {
        Success = success;
    }

    @JsonIgnore
    public int getCode() {
        return Code;
    }

    @JsonIgnore
    public void setCode(int code) {
        Code = code;
    }

    @JsonIgnore
    public String getMessage() {
        return Message;
    }

    @JsonIgnore
    public void setMessage(String message) {
        Message = message;
    }

    @JsonIgnore
    public String getDescription() {
        return Description;
    }

    @JsonIgnore
    public void setDescription(String description) {
        Description = description;
    }

    @JsonIgnore
    public T getData() {
        return Data;
    }

    @JsonIgnore
    public void setData(T data) {
        Data = data;
    }

    public void setCodeByHttpStatusCode(int httpStatusCode){
        Code = httpStatusCode;
    }
    /// <summary>
    ///
    /// </summary>
    /// <param name="data"></param>
    public InvokeResult success(T data)
    {
        this.Success = true;
        this.Code = InvokeCode.Success;
        this.Message = "操作成功！";
        this.Data = data;
        this.Description = "";
        return this;
    }

    /// <summary>
    ///
    /// </summary>
    /// <param name="code"></param>
    /// <param name="message"></param>
    /// <param name="description"></param>
    public InvokeResult error(int code, String message, String description)
    {
        this.Success = false;
        this.Code = code;
        this.Message = message;
        this.Description = description;
        return this;
    }

    public InvokeResult error(InvokeException e)
    {
        return error(e.getCode(),e.getMsg(),e.getDetails());
    }
}
