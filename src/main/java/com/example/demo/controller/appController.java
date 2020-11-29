package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.Result;
import com.example.demo.common.ResultMain;
import com.example.demo.dao.AuditDao;
import com.example.demo.entities.AuditUser;
import com.example.demo.entities.UserRegister;
import com.example.demo.models.UserContact;
import com.example.demo.netty.entity.ChatMessage;
import com.example.demo.netty.entity.UserChannels;
import com.example.demo.netty.server.ChattingServer;
import com.example.demo.netty.server.ChattingServerHandler;
import com.example.demo.service.UserServiceImpl;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
public class appController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    AuditDao dao;


    //ChattingServer simpleChatServer=new ChattingServer(8585);
    //登陆（post请求）
    @PostMapping("login")
    public Result login(@RequestBody UserRegister userRegister){

        //数据库中调出的密码
        String pwd=userService.findPwd(userRegister.getP_telephone());

        if(pwd.equals(userRegister.getP_password())){
            //登陆成功 获取token
            String token=userService.returnToken(userRegister.getP_telephone());
            //登陆成功 查询用户的所有信息
            UserRegister user=userService.infoByUser(userRegister.getP_telephone());
            //返回用户的所有信息
            return ResultMain.success(user);

        }else
            //登陆失败
            return ResultMain.error("密码或手机号错误");
    }
    //获取所有用户
    @PostMapping("findAllUsers")
    public Result findAllUsers(){

        List<UserRegister> userregisters=userService.findAllUsers();
        if(userregisters.size()!=0){
            return ResultMain.success(userregisters);
        }
        else{
            return ResultMain.error("获取失败");
        }
    }

    //查询联系人接口(根据电话号码查询）
    @PostMapping("findContact")
    public Result findContact(@RequestBody UserRegister userRegister){

        if(userRegister!=null){
            //查询出此联系人的信息
            UserRegister user=userService.infoByUser(userRegister.getP_telephone());
            if(user==null){
                return ResultMain.error("查无此人");
            }
            //联系人的电话号码和名字
            UserContact userContact = new UserContact();
            System.out.println(user.getP_name());
            userContact.setP_telephone(user.getP_telephone());
            userContact.setC_name(user.getP_name());
            return ResultMain.success(userContact);
        }else {
            return ResultMain.error("输入有误");
        }
    }

    //新增联系人
    @PostMapping("addContact")
    public Result addContact(@RequestBody UserContact userContact) {

        //先查询出此用户的所有联系人
        String contact = userService.findAllContacts(userContact.getP_telephone());
        System.out.println(contact);
        if (contact == null) {
            //若没有联系人
            List<UserContact> userContacts=new ArrayList<UserContact>();
            userContacts.add(userContact);
            //联系人转为json字符串存入数据库
            String contacts = JSONObject.toJSONString(userContacts);

            System.out.println(userContact.getP_telephone());
            if (userService.addContact(contacts, userContact.getP_telephone())) {
                //存储成功
                UserRegister userRegister = userService.infoByUser(userContact.getP_telephone());

                return ResultMain.success(userRegister);
            } else {

                return ResultMain.error("添加联系人失败");
            }
        } else {
            //将Json字符串转为对象
            List<UserContact> userContacts = JSONArray.parseArray(contact,UserContact.class);
            //将要添加的联系人追加进去
            userContacts.add(userContact);
            //再将追加后的所有联系人转为json字符串存入数据库
            String contacts = JSONObject.toJSONString(userContacts);
            if (userService.addContact(contacts, userContact.getP_telephone())) {
                //存储成功
                UserRegister userRegister = userService.infoByUser(userContact.getP_telephone());

                return ResultMain.success(userRegister);
            } else {

                return ResultMain.error("添加联系人失败");
            }
        }
    }
    //批量审核用户
    @PostMapping("auditUser")
    public Result auditUser(@RequestBody AuditUser auditUser){
        List<UserRegister> userRegisters=auditUser.getUserRegisterList();
        if(auditUser.getIsPass()==1){
            //如果审核通过
            //批量修改数据库
            dao.auditUserSuc(userRegisters);
            return ResultMain.success("审核通过");
        }
        else{
            //如果审核通过
            //批量修改数据库
            dao.auditUserDef(userRegisters);
            return ResultMain.success("审核未通过");
        }
    }
    //修改资料
    @PostMapping("updateperson")
    public Result updateperson(@RequestBody UserRegister user){

        UserRegister userRegister=userService.infoByUser(user.getP_telephone());
        System.out.println(user.getP_name());
        if(user.getP_headPhoto()!=null){
            userRegister.setP_headPhoto(user.getP_headPhoto());
        }
        if(user.getP_name()!=null){
            userRegister.setP_name(user.getP_name());
            System.out.println(userRegister.getP_name());
        }
        if(user.getP_address()!=null){
            userRegister.setP_address(user.getP_address());
        }
        if(userService.updateUser(userRegister)){
            //若修改成功
            //return ResultMain.success(userRegister);
            return ResultMain.success("修改成功");
        }else
            return ResultMain.error("修改失败");



    }
    //获取全部用户
    @PostMapping("getallUser")
    public Result getallUser(){
        List<UserRegister> list=userService.getallUser();
        if(list==null){
            return ResultMain.error("无用户存在");
        }else
            return ResultMain.success(list);
    }

    //添加收藏
    @PostMapping("addshoucang")
    public Result addshoucang(@RequestHeader String p_id,@RequestHeader String article_id){
        int pId=Integer.parseInt(p_id);
        int articleId=Integer.parseInt(article_id);
        String shoucang=userService.getshoucang(pId);
        if(shoucang==null){
            //若没有收藏的
            List<Integer> ids=new ArrayList<Integer>();
            ids.add(articleId);
            //联系人转为json字符串存入数据库
            String shoucangs = JSONObject.toJSONString(ids);
            if(userService.addchoucang(shoucangs,pId)){
                return ResultMain.success("添加成功");
            }else
                return ResultMain.error("添加失败");

        }else {
            //将Json字符串转为对象
            List<Integer> ids = JSONArray.parseArray(shoucang,Integer.class);
            //将要添加的收藏追加进去
            ids.add(articleId);
            //再将追加后的所有联系人转为json字符串存入数据库
            String shoucangs = JSONObject.toJSONString(ids);
            if(userService.addchoucang(shoucangs,pId)){
                return ResultMain.success("添加成功");
            }else
                return ResultMain.error("添加失败");
        }
    }
    @PostMapping("getshoucang")
    public Result getshoucang(@RequestHeader String p_id){
        int pId=Integer.parseInt(p_id);
        String shoucang=userService.getshoucang(pId);
        if(shoucang==null){
            return ResultMain.error("失败");
        }else{
            //将Json字符串转为对象
            List<Integer> ids = JSONArray.parseArray(shoucang,Integer.class);
            return ResultMain.success(ids);
        }

    }


}
