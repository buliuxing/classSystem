package com.system.exception;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 9:09 PM
 * @description：
 */

public class CustomException extends Exception {

    public String message;

    public CustomException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
