package com.example.demo.dao;

import com.example.demo.common.Result;
import com.example.demo.entities.AuditUser;
import com.example.demo.entities.UserRegister;

import io.rong.methods.user.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    //查询出相应手机号的密码 用于登陆操作 （返回用户的密码）
    @Select("select p_password from usertable where p_telephone=#{p_telephone}")
    public String findPwd(String p_telephone);

    //登陆成功后返回token
    @Select("select p_token from usertable where p_telephone=#{p_telephone}")
    public String returnToken(String p_telephone);

    //查询此用户的所有信息
    @Select("select * from usertable where p_telephone=#{p_telephone}")
    public UserRegister infoByUser(String p_telephone);

    //获取所有用户信息
    @Select("select * from usertable")
    public List<UserRegister> findAllUsers();

    //新增用户
    @Update("update usertable set p_contact=#{p_contact} where p_telephone=#{p_telephone}")
    public boolean addContact(String p_contact,String p_telephone);

    //查询出某一用户的所有联系人
    @Select("select p_contact from usertable where p_telephone=#{p_telephone}")
    public String findAllContacts(String p_telephone);


    @Update("update usertable set p_headPhoto=#{userRegister.p_headPhoto},p_name=#{userRegister.p_name}" +
            ",p_address=#{userRegister.p_address} where p_telephone=#{userRegister.p_telephone}")
    //用户修改资料
    public boolean updateUser(@Param("userRegister") UserRegister userRegister);

    @Select("select apk_version from apkVersion")
    public String getversion();

    @Update("update apkVersion set apk_version=#{apk_version}")
    public boolean updateVersion(String apk_version);

    @Select("select * from usertable")
    public List<UserRegister> getallUser();

    //返回用户的收藏
    @Select("select p_shoucang from usertable where p_id=#{p_id}")
    public String getshoucang(int p_id);

    @Update("update usertable set p_shoucang=#{p_shoucang} where p_id=#{p_id}")
    public boolean addchoucang(String p_shoucang,int p_id);

}
