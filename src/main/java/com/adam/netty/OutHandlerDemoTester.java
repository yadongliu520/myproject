package com.adam.netty;

import com.adam.multithread.ThreadState;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-23 11:12
 **/
public class OutHandlerDemoTester {
    public void outHandlerLifeCircle(){
        OutHandlerDemo outHandlerDemo=new OutHandlerDemo();
        ChannelInitializer init=new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel ch) throws Exception {
                ch.pipeline().addLast(outHandlerDemo);
            }
        };
        EmbeddedChannel ch=new EmbeddedChannel(init);
        ByteBuf buf= Unpooled.buffer();
        buf.writeInt(1);
        ChannelFuture f=ch.pipeline().writeAndFlush(buf);


        f.addListener((ChannelFuture future)->{
            if(future.isSuccess()){
                System.out.println("Write has finished!");
            }
            ch.close();
        });
        ThreadState.SleepUtils.second(60);

    }

    public static void main(String[] args) {
        OutHandlerDemoTester outHandlerDemo=new OutHandlerDemoTester();
        outHandlerDemo.outHandlerLifeCircle();
    }
}
