package com.adam.netty.echoserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-23 16:21
 **/
@ChannelHandler.Sharable
public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    private final static EchoClientHandler instance = new EchoClientHandler();
    public static EchoClientHandler getInstance1(){
        return instance;
    }

    private static class InstanceHolder{
        public static EchoClientHandler instance=new EchoClientHandler();
    }

    public static EchoClientHandler getInstance2(){
        return InstanceHolder.instance;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
        ByteBuf buf=(ByteBuf)msg;
        int len= buf.readableBytes();
        byte[] bytes=new byte[len];
        buf.getBytes(0,bytes);
        String out=new String(bytes, "UTF-8");
        System.out.println("CLient received msg:" + out);
    }
}
