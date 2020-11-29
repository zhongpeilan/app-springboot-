package com.example.demo.common;

/**
 * Created by yzd on 2019/2/2.
 */

public enum MessageCode {
    success(200,"成功"),
    error(0,"失败"),
    Exception1(-1,"异常");
    private int code;
    private String message;
    MessageCode(int code,String message){
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}