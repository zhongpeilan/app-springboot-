package com.example.demo.netty.entity;

import org.msgpack.annotation.Index;
import org.msgpack.annotation.Message;

//消息实体，协议
//所有的消息都被解码包装成这个类，然后直接对这个类的对象进行读写操作即可

/*这个类包含了发送消息的用户、接受消息的用户、消息的内容、消息的类型，
分别生成他们的get和set方法，并且为了方便调试，生成他的tostring方法。*/
@Message
public class ChatMessage {
    @Index(0)
    private String sendUser;
    @Index(1)
    private String receiveUser;
    @Index(2)
    private String message;
    @Index(3)
    private int messagetype;//1:初始化认证消息，2：聊天消息

    public ChatMessage() {
    }

    public ChatMessage(String sendUser, String receiveUser, String message, int messagetype){
        this.sendUser=sendUser;
        this.receiveUser=receiveUser;
        this.message=message;
        this.messagetype=messagetype;
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser;
    }

    public String getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(String receiveUser) {
        this.receiveUser = receiveUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(int messagetype) {
        this.messagetype = messagetype;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "sendUser='" + sendUser + '\'' +
                ", receiveUser='" + receiveUser + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
