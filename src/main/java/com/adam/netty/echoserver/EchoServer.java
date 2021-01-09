package com.adam.netty.echoserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-23 16:20
 **/
public class EchoServer {
    ServerBootstrap bootstrap=new ServerBootstrap();
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void runServer() throws InterruptedException {

            EventLoopGroup bossEventLoopGroup = new NioEventLoopGroup(1);
            EventLoopGroup workerEventLoopGroup = new NioEventLoopGroup();
        try{
            bootstrap.group(bossEventLoopGroup, workerEventLoopGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.localAddress("127.0.0.1",port);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            bootstrap.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            bootstrap.childHandler(new ChannelInitializer() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast(EchoServerHandler.getInstance1());
                    System.out.println("initChannel: add EchoServerHandler.");
                    //ch.pipeline().addLast(new EchoServerHandler());
                }
            });

            ChannelFuture future = bootstrap.bind().sync();
            ChannelPipeline pipeline =future.channel().pipeline();
            System.out.println("Binded port" + future.channel().localAddress());
            ChannelFuture closeFuture = future.channel().closeFuture();
            closeFuture.sync();
        }finally {
            bossEventLoopGroup.shutdownGracefully();
            workerEventLoopGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        EchoServer server=new EchoServer(10001);
        server.runServer();
    }
}
