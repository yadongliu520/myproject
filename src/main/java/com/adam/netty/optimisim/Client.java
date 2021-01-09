package com.adam.netty.optimisim;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;

import java.util.concurrent.ExecutionException;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-28 23:00
 **/
public class Client {

    public void start(int port) throws ExecutionException, InterruptedException {
        Bootstrap bootstrap=new Bootstrap();
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();
        bootstrap.group(eventLoopGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_REUSEADDR, true);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new FixedLengthFrameDecoder(Long.BYTES));//避免半包问题
                //ch.pipeline().addLast(ClientHandler.getInstance());
                ch.pipeline().addLast(new ClientHandler());
            }
        });

        for(int i=0;i<1;i++){
            bootstrap.connect("127.0.0.1", port).get();
            //System.out.println("Add conn.");
        }

    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Client().start(8000);
    }
}
