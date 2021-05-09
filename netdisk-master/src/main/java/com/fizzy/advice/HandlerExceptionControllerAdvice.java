package com.fizzy.advice;

import com.fizzy.exception.MyException;
import com.fizzy.query.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class HandlerExceptionControllerAdvice {

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public JSONResult error(MyException me)
    {
        System.out.println("MyException = " + me);
        return new JSONResult().noSuccess(me.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JSONResult error(Exception e)
    {
        System.out.println("Exception = " + e);
        return new JSONResult().noSuccess(e.getMessage());
    }
}
