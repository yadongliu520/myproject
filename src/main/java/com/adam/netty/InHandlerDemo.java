package com.adam.netty;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-23 09:49
 **/

public class InHandlerDemo extends ChannelInboundHandlerAdapter{
      @Override
      public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            System.out.println("被调用：handlerAdded()");
            super.handlerAdded(ctx);
      }

      @Override
      public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("被调用：channelRegistered()");
            super.channelRegistered(ctx);
      }

      @Override
      public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("被调用：channelActive()");
//            ctx.executor().scheduleAtFixedRate(()->{
//                  System.out.println("channelActive.");
//            },0,1, TimeUnit.SECONDS);
            super.channelActive(ctx);
      }

      @Override
      public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("被调用：channelRead()");
            super.channelRead(ctx, msg);
      }

      @Override
      public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            System.out.println("被调用：channelReadComplete()");
            super.channelReadComplete(ctx);
      }

      @Override
      public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("被调用：channelInactive()");
            super.channelInactive(ctx);
      }

      @Override
      public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("被调用: channelUnregistered()");
            super.channelUnregistered(ctx);
      }

      @Override
      public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
            System.out.println("被调用：handlerRemoved()");
            super.handlerRemoved(ctx);
      }

}
