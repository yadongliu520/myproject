package com.adam.netty.echoserver;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-23 16:21
 **/
public class EchoClient2 {
   private final String SERER_IP;
   private final int SERVER_PORT;
   Bootstrap bootstrap=new Bootstrap();
   public EchoClient2(String server_ip, int server_port ){
       this.SERER_IP=server_ip;
       this.SERVER_PORT=server_port;
   }

   public void runClient() throws InterruptedException, UnsupportedEncodingException {
       EventLoopGroup workEventLoopGroup =new NioEventLoopGroup();
       try {
           bootstrap.group(workEventLoopGroup);
           bootstrap.remoteAddress(SERER_IP, SERVER_PORT);
           bootstrap.channel(NioSocketChannel.class);
           bootstrap.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
           bootstrap.handler(new ChannelInitializer() {
               @Override
               protected void initChannel(Channel ch) throws Exception {
                   ch.pipeline().addLast(EchoClientHandler.getInstance1());
               }
           });

           ChannelFuture future = bootstrap.connect();
           future.addListener((ChannelFuture listener) -> {
               if (listener.isSuccess()) {
                   System.out.println("Client connected successfully.");
               } else
                   System.out.println("Client connected unsuccessfully.");

           });

           future.sync();
           Channel channel = future.channel();
           Scanner scanner = new Scanner(System.in);
           System.out.println("Please input:");
           while (scanner.hasNextLine()) {
               String in = scanner.nextLine();
               ByteBuf buf = PooledByteBufAllocator.DEFAULT.buffer();
               buf.writeBytes(in.getBytes("UTF-8"));
               channel.writeAndFlush(buf);
           }
       }finally {
           workEventLoopGroup.shutdownGracefully();
       }
   }

    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
       EchoClient2 client=new EchoClient2("127.0.0.1", 10001);
        client.runClient();
    }
}
