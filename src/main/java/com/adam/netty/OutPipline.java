package com.adam.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.channel.embedded.EmbeddedChannel;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-23 11:38
 **/
public class OutPipline extends ChannelOutboundHandlerAdapter {
    public static  class SimpleOutHandlerA extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            System.out.println("出站处理器 A: 被回调" );
            ByteBuf buf=(ByteBuf)msg;
            System.out.println("Msg Out:"+buf.readInt());
            super.write(ctx, msg, promise);
        }
    }
    public static  class SimpleOutHandlerB extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            System.out.println("出站处理器 B: 被回调" );
            ByteBuf buf=(ByteBuf)msg;

            super.write(ctx, msg, promise);
        }
    }
    public static  class SimpleOutHandlerC extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            System.out.println("出站处理器 C: 被回调" );
            ByteBuf buf=Unpooled.buffer();
            msg=buf.writeInt(2);
            super.write(ctx, msg, promise);

        }
    }

    public static void main(String[] args) {
        ChannelInitializer i = new ChannelInitializer<EmbeddedChannel>() {
            protected void initChannel(EmbeddedChannel ch) {
                ch.pipeline().addLast(new InPipeline.HandlerA());
                ch.pipeline().addLast(new InPipeline.HandlerB());

                ch.pipeline().addLast(new SimpleOutHandlerA());
                ch.pipeline().addLast(new SimpleOutHandlerB());
                ch.pipeline().addLast(new SimpleOutHandlerC());
                ch.pipeline().addLast(new InPipeline.HandlerC());

            }
        };
        EmbeddedChannel channel = new EmbeddedChannel(i);
        ByteBuf buf = Unpooled.buffer();
        buf.writeInt(1);

        channel.writeInbound(buf);

        channel.writeOutbound(buf);
        ByteBuf buf2 = channel.readOutbound();
        System.out.println("len: "+ buf2.readableBytes());


    }
}
