package com.example.demo.netty.Coder;

import com.example.demo.netty.entity.ChatMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

//编码器 将ChatMessage编码成字节在通道中进行发送传输

public class ChatMsgEncoder extends MessageToByteEncoder<ChatMessage> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ChatMessage chatMessage, ByteBuf byteBuf) throws Exception {
        MessagePack msgpack=new MessagePack();
        byte[] msg=msgpack.write(chatMessage);
        byteBuf.writeBytes(msg);
    }
}
