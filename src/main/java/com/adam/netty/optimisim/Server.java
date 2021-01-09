package com.adam.netty.optimisim;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-28 23:00
 **/
public class Server {
    private static final int PORT=8000;

    public static void main(String[] args) {
        EventLoopGroup bossEventLoopGroup=new NioEventLoopGroup();
        EventLoopGroup workerEventLoopGroup =new NioEventLoopGroup();
        EventLoopGroup bussinessGroup=new NioEventLoopGroup();
        ServerBootstrap  bootstrap=new ServerBootstrap();
        bootstrap.group(bossEventLoopGroup,workerEventLoopGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childOption(ChannelOption.SO_REUSEADDR, true);
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new FixedLengthFrameDecoder(Long.BYTES));//避免半包问题
                //ch.pipeline().addLast(bussinessGroup,ServerHandler.getInstance());
                ch.pipeline().addLast(bussinessGroup,ServerThreadPoolHandler.getInstance());
            }
        });

       ChannelFuture future= bootstrap.bind(PORT).addListener(new ChannelFutureListener() {
           @Override
           public void operationComplete(ChannelFuture future) throws Exception {
               System.out.println("Server has started, port:" + PORT);
           }
       });
        System.out.println("END.");
    }
}
