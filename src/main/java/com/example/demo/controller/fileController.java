package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.common.ResultMain;
import com.example.demo.service.FileUploadImpl;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@RestController
public class fileController {
    @Autowired
    FileUploadImpl fileUpload;
    @Autowired
    UserServiceImpl userService;

    //上传apk
    @PostMapping("uploadapk")
    public Result uploadapk(@RequestParam("apk") MultipartFile apk,@RequestParam("apk_version") String apk_version){
        try {
            fileUpload.uploadApk(apk);
            //修改成功后，修改数据库的版本号

            userService.updateVersion(apk_version);
            return ResultMain.success("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return ResultMain.success("上传失败");
        }
    }

    //获取版本号
    @PostMapping("getversion")
    public Result getversion(){
        String apkVersion=userService.getversion();
        return ResultMain.success(apkVersion);
    }

}
