package com.example.demo.common;


/**
 * Created by yzd on 2019/2/2.
 */
public class ResultMain {
//操作失败
    public static <T> Result error(T t){
        Result result =new Result(MessageCode.error);
        result.setData(t);
        result.setRetult(true);
        return result;
    }
    //操作成功
    public static <T> Result success(T t){
        Result result =new Result(MessageCode.success);
        result.setData(t);
        result.setRetult(true);
        return result;
    }

}