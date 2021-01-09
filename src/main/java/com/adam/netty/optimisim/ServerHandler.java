package com.adam.netty.optimisim;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-28 23:10
 **/
@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler {
    private static final ServerHandler INSTANCE=new ServerHandler();
    public static ServerHandler getInstance(){
        return INSTANCE;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf data= Unpooled.directBuffer();
        data.writeBytes((ByteBuf)msg);
        Object result=getResult(data);
        ctx.channel().writeAndFlush(result);
    }

    protected Object getResult(ByteBuf buf){
        int level= ThreadLocalRandom.current().nextInt(1,1000);
        int time=0;
        if(level<900)
            time=1;
        else if(level<950)
            time=10;
        else if(level<990)
            time=100;
        else
            time=1000;
        try{
            Thread.sleep(time);
        }catch (Exception e){

        }
        return buf;
    }
}
