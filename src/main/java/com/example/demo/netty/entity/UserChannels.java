package com.example.demo.netty.entity;


import io.netty.channel.Channel;
import java.util.HashMap;
import java.util.Map;

//用于将在线用户的用户名和对应通道相匹配
//我们将连接到服务器的用户的用户名和其对应的通道存储到Map中，并提供通过用户名查找通道的方法，这样就可以实现私聊了
//通过用户名查找通道的方法
public class UserChannels {


    private Map<String, Channel> onlineUsers=new HashMap<String,Channel>();

    /**
     * 添加在线用户
     * @param username
     * @param channel
     */
    public void addOnlineUser(String username,Channel channel){
        onlineUsers.put(username,channel);
    }

    /**
     * 移除在线用户
     * @param username
     */
    public void removeOnlineUser(String username){
        onlineUsers.remove(username);
    }

    /**
     * 移除通道
     * @param channel
     */
    public void removeChannel(Channel channel){
        for (Map.Entry<String, Channel> entry : onlineUsers.entrySet()) {
            if(entry.getValue()==channel){
                onlineUsers.remove(entry.getKey());
            }
        }
    }

    /**
     * 根据用户名获取在线用户的通道
     * @param username
     * @return
     */
    public Channel getChannel(String username){
        return onlineUsers.get(username);
    }

    /**
     *获取在线用户列表信息
     * @return
     */
    public Map<String, Channel> getOnlineUsers() {
        return onlineUsers;
    }
    /**
     * 获取储存池链接数
     * @return 在线数
     */
    public Integer getSize(){
        return onlineUsers.size();
    }


}