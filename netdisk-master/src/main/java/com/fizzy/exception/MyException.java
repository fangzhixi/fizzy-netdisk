package com.fizzy.exception;


/**
 * RuntimeException  運行時異常
 */
public class MyException  extends  RuntimeException{

    private String message;

    public MyException(String message)
    {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
