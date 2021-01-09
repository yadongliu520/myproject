package com.adam.netty.echoserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;

import java.io.UnsupportedEncodingException;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-23 16:21
 **/
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    private final static EchoServerHandler INTSTANCE=new EchoServerHandler();
    public static EchoServerHandler getInstance1(){
        return INTSTANCE;
    }

    private static class InstanceHolder{
        public final static EchoServerHandler INSTANCE=new EchoServerHandler();
    }

    public static EchoServerHandler getInstance2(){
        return InstanceHolder.INSTANCE;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
        ByteBuf in=(ByteBuf)msg;
        boolean isDirectMemory=in.hasArray();
        int len=in.readableBytes();
        byte[] arr= new byte[len];
        in.getBytes(0, arr);
        String content=new String(arr,"UTF-8");
        System.out.println(String.format("Server receive msg: %s. len: %d. It is directMemory? %s", content,
                len, !isDirectMemory));

        System.out.println("Before write, msg refCnt: " + ((ByteBuf)msg).refCnt());
        ChannelFuture future=ctx.writeAndFlush(msg);
        future.addListener((ChannelFurure)->{
            System.out.println("After write, msg refCnt: " + ((ByteBuf)msg).refCnt());
        });
    }

}
