package com.adam.netty.optimisim;

import com.adam.multithread.ThreadState;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-30 10:00
 **/
@ChannelHandler.Sharable
public class ClientHandler extends SimpleChannelInboundHandler {
    private static final ClientHandler INSTANCE=new ClientHandler();
    private static AtomicLong beginTime =new AtomicLong(0);
    private static AtomicLong totalReposonTime =new AtomicLong(0);
    private static AtomicInteger totalRequestNum =new AtomicInteger(0);

    public static ClientHandler getInstance(){
        return INSTANCE;
    }

    public static final Thread THREAD=new Thread(){
        @Override
        public void run(){
            while(true){
                long druation=System.currentTimeMillis() -beginTime.get();
                if(druation>0) {
                    long qps = 1000* totalRequestNum.get() / druation;
                    float avgTime = totalReposonTime.get() / druation;
                    System.out.println("QPS: " + qps + ", avgTime: " + avgTime + "ms.");
                    System.out.println("totalRequestNum: " + totalRequestNum +
                            ". totalReposonTime " + totalReposonTime +". druation: "+ druation + ". begginTime: " + beginTime);
                    ThreadState.SleepUtils.second(2);
                }
            }
        }
    };

    @Override
    public void channelActive(final ChannelHandlerContext ctx){
        ctx.executor().scheduleAtFixedRate(()->{
            ByteBuf buf=ctx.alloc().buffer();
            buf.writeLong(System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() + " Send a msg.");
            ctx.pipeline().writeAndFlush(buf);
        },0,2, TimeUnit.SECONDS);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        totalReposonTime.addAndGet(System.currentTimeMillis()-((ByteBuf)msg).readLong());
        totalRequestNum.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + " recived a msg.");
        if(beginTime.compareAndSet(0,System.currentTimeMillis())){
            THREAD.start();
            System.out.println(Thread.currentThread().getName() + " of thread started.");
        }
    }
}
