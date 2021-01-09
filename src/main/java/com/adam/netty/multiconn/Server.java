package com.adam.netty.multiconn;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-27 20:44
 **/
public class Server {
    public static final int START_PORT=8000;
    public static final int END_SPORT=8001;

    public void start(int start_port, int end_port){
        ServerBootstrap bootstrap=new ServerBootstrap();
        EventLoopGroup bossEventLoopGroup =new NioEventLoopGroup();
        EventLoopGroup workerEventLoopGroup =new NioEventLoopGroup();
        bootstrap.group(bossEventLoopGroup,workerEventLoopGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childOption(ChannelOption.SO_REUSEADDR, true);
        bootstrap.childHandler(new ConnectionHandle());

        for(int i=0;i<=(end_port-start_port);i++){
            final int port=start_port+i;
            bootstrap.bind(port).addListener(new ChannelFutureListener(){
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    System.out.println("Success to bind port: "+port);
                }
            });
            bootstrap.childHandler(new ConnectionHandle());

        }
        System.out.println("Server has started!");
    }

    public static void main(String[] args) {
        new Server().start(START_PORT, END_SPORT);
    }

}
