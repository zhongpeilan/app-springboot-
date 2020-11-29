package com.example.demo.netty.server;

import com.example.demo.netty.entity.UserChannels;

import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
//负责业务逻辑
public class ChattingServerHandler extends ChannelInboundHandlerAdapter{
    //负责将每个连接到服务器的 channel放入 channeldroup中
    public static ChannelGroup channels=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //用户电话和channel一对一
    public static Map<String,Channel> nettyUserMap=new HashMap<String,Channel>();
    //UserChannels的实例化对象 用于私聊使用
    public static UserChannels uc=new UserChannels();
    /*private List<NettyUser> nettyUsers=new ArrayList<>();*/
    //新客户端进入时，将其加入channel队列
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel newchannel=ctx.channel();
        System.out.println("欢迎新客户端："+newchannel.remoteAddress());
        for(Channel ch:channels){
            if(ch!=newchannel){
                ch.writeAndFlush("欢迎新客户端："+newchannel.remoteAddress());
            }
        }
        //channels.writeAndFlush("欢迎新客户端："+newchannel.remoteAddress());
        channels.add(newchannel);
    }

    //有客户端断开连接后，将其移出队列
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel newchannel =ctx.channel();
        for(Channel ch:channels) {
            if (ch != newchannel) {
                ch.writeAndFlush(newchannel.remoteAddress() + "退出聊天室");
            }
        }
        channels.remove(newchannel);

    }

    //这儿接收数据 因为我们不做聊天室 所以我们不转发给其他人 用户登陆传了一个nettyuser的话报cun到list钟
    /*
    ctx:用户ip
    msg：用户发的信息
     */

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel newchannel=ctx.channel();
        String phone=(String)msg;//传过来的是phone

        System.out.println("接收消息！！！！！！！！！-------"+phone+"--------!!!!!!!!!");
        if(nettyUserMap.containsKey(phone)){
            //如果map中已经有一个相同的phone存在
            //获取先前用户的channel
            Channel oldchannel=nettyUserMap.get(phone);
            //在map中移除先前的用户
            nettyUserMap.remove(phone);
            //发消息
            oldchannel.writeAndFlush("finish"+"\n");

            //添加新的登陆进去
            nettyUserMap.put(phone,newchannel);
        }else {
            //如果map无此用户的电话 则是首次登陆
            //添加进map中
            nettyUserMap.put(phone,newchannel);
        }


    }


    //服务器监听到客户端活动时
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel newchannel=ctx.channel();
        System.out.println("["+newchannel.remoteAddress()+"]：在线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel newchannel=ctx.channel();
        System.out.println("["+newchannel.remoteAddress()+"]：离线了");
        ctx.close();
        channels.remove(newchannel);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel newchannel=ctx.channel();
        System.out.println("["+newchannel.remoteAddress()+"]：通讯异常");
        System.out.println(cause.getMessage());
        newchannel.close();
    }


}

