package com.example.aop.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import service.bean.InvokeException;

@ControllerAdvice
public class RestAdvice {
    @ExceptionHandler(InvokeException.class)
    @ResponseBody
    public InvokeResult InvokeE(InvokeException ex){
        return new InvokeResult().error(ex);
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public InvokeResult InvokeE(Exception ex){
        return new InvokeResult().error(500,ex.getMessage(),ex.toString());
    }
}
