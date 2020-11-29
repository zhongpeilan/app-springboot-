package com.example.demo.service;



import com.example.demo.common.Result;
import com.example.demo.entities.UserRegister;

import java.util.List;


public interface IUserService {

    //查询出相应手机号的密码 用于登陆操作
    public String findPwd(String p_telephone);

    //查询此用户的所有信息
    public UserRegister infoByUser(String p_telephone);

    //登陆成功后返回token
    public String returnToken(String p_telephone);

    //获取所用用户的信息
    public List<UserRegister> findAllUsers();

    //新增联系人
    public boolean addContact(String p_contact,String p_telephone);

    //查询出某一用户的所有联系人
    public String findAllContacts(String p_telephone);

    //用户修改资料
    public boolean updateUser(UserRegister userRegister);
    //返回版本号
    public String getversion();
    //修改版本号
    public boolean updateVersion(String apk_version);
    //获取所有用户
    public List<UserRegister> getallUser();

    //返回用户的收藏
    public String getshoucang(int p_id);

    //添加收藏
    public boolean addchoucang(String p_shoucang,int p_id);
}
