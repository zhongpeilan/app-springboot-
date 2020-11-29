package com.example.demo.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileUpload {

    public void uploadApk(MultipartFile apk) throws IOException;

}
