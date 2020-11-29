package com.example.demo.service;

import com.example.demo.common.Contants;
import com.example.demo.common.Result;
import com.example.demo.common.ResultMain;

import com.example.demo.dao.AuditDao;
import com.example.demo.entities.UserRegister;
import org.apache.commons.io.FileUtils;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@org.springframework.stereotype.Service
public class Service {
    @Resource
    AuditDao dao;

    public Result register(UserRegister user, MultipartFile[] multipartFile){
        if(dao.checkphnum(user.getP_telephone())>0){
            return ResultMain.error("已经存在该用户");
        }else {
            try {
                for (int i = 0; i < multipartFile.length; i++) {
                    FileUtils.writeByteArrayToFile(new File("c:/upload/" + multipartFile[i].getOriginalFilename()), multipartFile[i].getBytes());//字节数组
                    System.out.println(""+multipartFile[i].getOriginalFilename());
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            user.setP_headPhoto(Contants.Api+multipartFile[0].getOriginalFilename());
            user.setP_idCardPositive(Contants.Api+multipartFile[1].getOriginalFilename());
            user.setP_idCardReverse(Contants.Api+multipartFile[2].getOriginalFilename());
//            TokenResult tokenResult= UserExample.rongResgister(user.getP_telephone(),user.getP_name(),user.getP_headPhoto());
//            if(tokenResult.getCode()==200){
//                //融云注册成功
//                user.setP_token(tokenResult.getToken());
                if (dao.registUser(user)==1){
                    return ResultMain.success("注册成功");
                }
        else {
                return ResultMain.error("融云注册失败");
            }
        }
    }


}
