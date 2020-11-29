package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Service
public class FileUploadImpl implements IFileUpload {
    @Override
    public void uploadApk(MultipartFile apk) throws IOException {
        String path="c:/upload/"+apk.getOriginalFilename();
        File newFile=new File(path);
        if(!newFile.exists()){
            //文件路径不存在
        }
        else{
            newFile.delete();
        }
        /*newFile.createNewFile();*/
        apk.transferTo(newFile);
    }
}
