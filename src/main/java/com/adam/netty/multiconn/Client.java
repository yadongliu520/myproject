package com.adam.netty.multiconn;

import com.adam.multithread.ThreadState;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.ExecutionException;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-28 09:41
 **/
public class Client {
    private static final String ADDR="127.0.0.1";
    public void startClient(int start_port, int end_port) throws ExecutionException, InterruptedException {
        Bootstrap bootstrap=new Bootstrap();
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();
        bootstrap.group(eventLoopGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {

            }
        });
        int port,index=0;
        while (!Thread.interrupted()){
            port=start_port+index;
            System.out.println("Port: "+ port);
            ChannelFuture future=bootstrap.connect(ADDR,port);
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if(!future.isSuccess()){
                        System.out.println("Client connected unsuccessfully.");
                        System.exit(0);
                    }else {
                        //System.out.println("Client connected successfully.");
                    }
                }
            });
            future.get();
            ThreadState.SleepUtils.second(1);

            if(port==end_port)index=0; else index++;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException{
        new Client().startClient(Server.START_PORT, Server.END_SPORT);
    }
}
