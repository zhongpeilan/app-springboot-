package com.example.demo.common;


/**
 * Created by yzd on 2019/2/2.
 */

public class Result<T> {
    private boolean retult;
    private String message;
    private int code;
    private T Data;

    public Result(MessageCode messageCode) {
        this.message = messageCode.getMessage();
        this.code = messageCode.getCode();
    }

    public boolean isRetult() {
        return retult;
    }

    public void setRetult(boolean retult) {
        this.retult = retult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}