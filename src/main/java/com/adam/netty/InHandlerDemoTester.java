package com.adam.netty;

import com.adam.multithread.ThreadState;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-23 10:19
 **/
public class InHandlerDemoTester {
    public void inHandlerLifeCircle(){
        final InHandlerDemo inHandler = new InHandlerDemo();
        final InHandlerDemo inHandler2 = new InHandlerDemo();
        final OutHandlerDemo outHandler =new OutHandlerDemo();
        ChannelInitializer init = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel ch) throws Exception {
                ch.pipeline().addLast(inHandler);
                ch.pipeline().addLast(inHandler2);
                ch.pipeline().addLast(outHandler);
            }
        };

        EmbeddedChannel ch=new EmbeddedChannel(init);
        ByteBuf buf= Unpooled.buffer();
        ByteBuf buf2= ByteBufAllocator.DEFAULT.buffer();
        buf.writeInt(1);
        ch.writeInbound(buf);
        //ch.flush();

//        ch.writeInbound(buf);
//        ch.flush();
//        ch.close();
//        ByteBuf outBuf=ch.readOutbound();
//        int len=outBuf.readableBytes();
//        byte[] bytes=new byte[len];
//        outBuf.getBytes(0,bytes);
//        System.out.println("out:" + new String(bytes));

        ByteBuf outBuf=ch.readOutbound();
        outBuf.getBytes(0, new byte[outBuf.readableBytes()]);

       // ThreadState.SleepUtils.second(5);
    }

    public static void main(String[] args) {
        InHandlerDemoTester tester=new InHandlerDemoTester();
        tester.inHandlerLifeCircle();
    }
}
