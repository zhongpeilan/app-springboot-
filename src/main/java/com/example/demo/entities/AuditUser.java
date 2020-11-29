package com.example.demo.entities;

import java.util.List;

public class AuditUser {
    private List<UserRegister> userRegisterList;
    private int isPass;

    public AuditUser(List<UserRegister> userRegisterList, int isPass) {
        this.userRegisterList = userRegisterList;
        this.isPass = isPass;
    }
    public AuditUser(){

    }

    public List<UserRegister> getUserRegisterList() {
        return userRegisterList;
    }

    public void setUserRegisterList(List<UserRegister> userRegisterList) {
        this.userRegisterList = userRegisterList;
    }

    public int getIsPass() {
        return isPass;
    }

    public void setIsPass(int isPass) {
        this.isPass = isPass;
    }
}
