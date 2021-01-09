package com.adam.netty.optimisim;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-30 16:56
 **/
@ChannelHandler.Sharable
public class ServerThreadPoolHandler extends ServerHandler{
    private static final ServerThreadPoolHandler INSTANCE=new ServerThreadPoolHandler();
    private AtomicInteger count=new AtomicInteger(0);
    public static ServerThreadPoolHandler getInstance(){
        return INSTANCE;
    }
    private static ExecutorService threadPool= Executors.newFixedThreadPool(10);

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg){
        final  ByteBuf data= Unpooled.directBuffer();
        ByteBuf in=(ByteBuf)msg;
        data.writeBytes((ByteBuf)msg);
        threadPool.submit(()->{
            Object result= getResult(data);
            ctx.channel().writeAndFlush(result);
            System.out.println(Thread.currentThread().getName() + " send msg cnt: " + count.incrementAndGet());
        });
    }
}
