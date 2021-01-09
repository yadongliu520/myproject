package com.adam.netty.multiconn;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-27 23:14
 **/
@ChannelHandler.Sharable
public class ConnectionHandle extends ChannelInboundHandlerAdapter {
    private AtomicInteger nConnection = new AtomicInteger();

    public  ConnectionHandle(){
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{
            System.out.println("Current client connection num: " + nConnection.get());
        },0,2, TimeUnit.SECONDS);
    }

    @Override
    public void channelActive(ChannelHandlerContext cxt){
        nConnection.incrementAndGet();
    }
    @Override
    public void channelInactive(ChannelHandlerContext cxt){
        //System.out.println("Conn decrease.");
        nConnection.decrementAndGet();
    }
}
