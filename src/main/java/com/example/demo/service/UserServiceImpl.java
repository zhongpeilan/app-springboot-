package com.example.demo.service;


import com.example.demo.common.Result;
import com.example.demo.dao.UserMapper;
import com.example.demo.entities.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String findPwd(String p_telephone) {
        return userMapper.findPwd(p_telephone);
    }

    @Override
    public UserRegister infoByUser(String p_telephone) {
        return userMapper.infoByUser(p_telephone);
    }

    @Override
    public String returnToken(String p_telephone) {
        return userMapper.returnToken(p_telephone);
    }


    @Override
    public List<UserRegister> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public boolean addContact(String p_contact, String p_telephone) {
        return userMapper.addContact(p_contact,p_telephone);
    }

    @Override
    public String findAllContacts(String p_telephone) {
        return userMapper.findAllContacts(p_telephone);
    }



    @Override
    public boolean updateUser(UserRegister userRegister) {
        return userMapper.updateUser(userRegister);
    }

    @Override
    public String getversion() {
        return userMapper.getversion();
    }

    @Override
    public boolean updateVersion(String apk_version) {
        return userMapper.updateVersion(apk_version);
    }

    @Override
    public List<UserRegister> getallUser() {
        return userMapper.getallUser();
    }

    @Override
    public String getshoucang(int p_id) {
        return userMapper.getshoucang(p_id);
    }

    @Override
    public boolean addchoucang(String p_shoucang, int p_id) {
        return userMapper.addchoucang(p_shoucang,p_id);
    }

}
