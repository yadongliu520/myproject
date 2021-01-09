package com.adam.netty;

import com.adam.multithread.ThreadState;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-23 10:44
 **/
public class InPipeline {
    static class HandlerA extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("Handle A has Called!");
           //super.channelRead(ctx,msg);
            ctx.fireChannelRead(msg); //效果一样

        }
    }

    static class HandlerB extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("Handle B has Called!");
            //ctx.channel().writeAndFlush(msg);
            super.channelRead(ctx,msg);
            ctx.pipeline().remove(this);

        }
    }

    static class HandlerC extends ChannelInboundHandlerAdapter{
        @Override
        public void channelRead(ChannelHandlerContext  ctx, Object msg) throws Exception {
            System.out.println("Handle C has Called!");
            //ctx.channel().writeAndFlush(msg);
            super.channelRead(ctx, msg);
        }
    }

    public static void main(String[] args) {
        ChannelInitializer init=new ChannelInitializer<EmbeddedChannel>(){

            @Override
            protected void initChannel(EmbeddedChannel ch) throws Exception {
                ch.pipeline().addLast(new HandlerA());
                ch.pipeline().addLast(new HandlerB());
                ch.pipeline().addLast(new HandlerC());
            }
        };

        EmbeddedChannel ch=new EmbeddedChannel(init);
        ByteBuf buf= Unpooled.buffer();
        buf.writeInt(1);
        ch.writeInbound(buf);
        ch.flush();
        buf.writeInt(2);
        ch.writeInbound(buf);
        ch.flush();
        ThreadState.SleepUtils.second(1);
    }

}
