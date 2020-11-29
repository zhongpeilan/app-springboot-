package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.MessageCode;
import com.example.demo.common.Result;
import com.example.demo.common.ResultMain;
import com.example.demo.entities.UserRegister;
import com.example.demo.service.Service;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


@RestController
public class Controller {
    @Resource
    private Service service;

    /**
     * 用户注册 电话号码 唯一  需要判断电话号码
     * @param
     * @return
     */
    @PostMapping("register")
    public Result register(@RequestParam("file") MultipartFile[] multipartFile,@RequestParam("user") String text) {
      UserRegister user= JSON.parseObject(text,UserRegister.class);
        if(user.getP_telephone()==null){
            //现在只做空校验
            return ResultMain.error("电话号码为空");
        }else {
            return service.register(user,multipartFile);
        }
    }
}
