package com.example.demo.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


//负责服务端的启动和初始化
public class ChattingServer {
    private final int port;
    public ChattingServer(int port){
        this.port = port;
        try{
            this.run();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
//    public void startServer() {
//
//        EventLoopGroup bossGroup=new NioEventLoopGroup();
//        EventLoopGroup workerGroup=new NioEventLoopGroup();
//
//
//        try {
//            ServerBootstrap bootstrap=new ServerBootstrap();
//            bootstrap.group(bossGroup, workerGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .option(ChannelOption.SO_BACKLOG, 1024)
//                    .option(ChannelOption.SO_KEEPALIVE, true)
//                    .childHandler(new ChattingServerInitializer());
//            ChannelFuture channelFuture = bootstrap.bind(port).sync();
//            System.out.println("服务器已启动！");
//            channelFuture.channel().closeFuture().sync();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
//    }
    public void run() throws Exception{
        new  Thread(){
            @Override
            public void run() {
                //boss用来接收进来的连接
                EventLoopGroup bossGroup = new NioEventLoopGroup();
                //用来处理已经被接收的连接;
                EventLoopGroup workerGroup = new NioEventLoopGroup();

                try{
                    //是一个启动NIO服务的辅助启动类
                    ServerBootstrap sBootstrap = new ServerBootstrap();
                    //These EventLoopGroup's are used to handle all the events and IO for ServerChannel and Channel's.
                    //为bootstrap设置acceptor的EventLoopGroup和client的EventLoopGroup
                    //这些EventLoopGroups用于处理所有的IO事件
                    //?这里为什么设置两个group呢?
                    sBootstrap.group(bossGroup, workerGroup)
                            .channel(NioServerSocketChannel.class)
                            .childHandler(new ChattingServerInitializer())//handler对应bossgroup chiledHandler对应workgroup
                            .option(ChannelOption.SO_BACKLOG, 128)
                            .childOption(ChannelOption.SO_KEEPALIVE, true);

                    System.out.println("SimpleChatServer  启动了");

                    //绑定端口,开始接收进来的连接
                    try{
                        ChannelFuture future = sBootstrap.bind(port).sync();
                        future.channel().closeFuture().sync();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

//            Channel channel=future.channel();
//            BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
//            while (true){
//                System.out.println(in.readLine());
//                    sendmessage(in.readLine());
//            }
                    //等待服务器socket关闭
                    //在本例子中不会发生,这时可以关闭服务器了

                } finally {
                    //
                    workerGroup.shutdownGracefully();
                    bossGroup.shutdownGracefully();
                    System.out.println("SimpleChatServer 关闭了");
                }

            }
        }.start();
        //NioEventLoopGroup是用来处理IO操作的多线程事件循环器

    }
    /*
        发送消息给所有正在连接的 用户
 */
    public  void sendMessageToAllUser(String message){
        if(ChattingServerHandler.channels.size()>0){
            for(Channel channel:ChattingServerHandler.channels){
                channel.writeAndFlush(message+"\n");
            }
        }
    }
    public void sendMsgByCURD(String msg){

    }
}
