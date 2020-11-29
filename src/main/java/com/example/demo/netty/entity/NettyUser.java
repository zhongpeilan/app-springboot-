package com.example.demo.netty.entity;


import io.netty.channel.Channel;


public class NettyUser {
    private String phone;
    private Channel channel;

    public NettyUser(String phone, Channel channel) {
        this.phone = phone;
        this.channel = channel;
    }
    public NettyUser(){

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
