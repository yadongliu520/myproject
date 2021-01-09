package com.adam.benchmark;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-27 09:42
 **/
@Warmup(iterations=1)
@Measurement(iterations=1,time=1)
@Threads(1)
@Fork(1)
@State(Scope.Thread)
public class ThreadLocalBenchMark {
//    ThreadLocal<Integer> jdkTheadLocal=new ThreadLocal<>();
//    FastThreadLocal<Integer> nettyFastTheadLocal = new FastThreadLocal<>();
    static ThreadLocal<Integer>[] jdkThreadLocalArr;
    static FastThreadLocal<Integer>[] nettyFastThreadLocal;
    static FastThreadLocal<Integer>[] nettyFastThreadLocal2;
    @Param({"30"})
    int size;

    @Setup
    public void setup() throws InterruptedException {
        jdkThreadLocalArr=new ThreadLocal[size];
        nettyFastThreadLocal=new FastThreadLocal[size];
        nettyFastThreadLocal2=new FastThreadLocal[size];
        Random random=new Random();
        for(int i=0;i<size;i++){
            int num=random.nextInt(10);
            jdkThreadLocalArr[i]=new ThreadLocal<Integer>(){
                @Override
                public Integer initialValue(){
                    return num;
                }
            };


            nettyFastThreadLocal[i]=new FastThreadLocal<Integer>(){
                @Override
                public Integer initialValue(){
                    return num;
                }
            };
        }

        FastThreadLocalThread thread= new FastThreadLocalThread(()->{
            for(int i=0; i<size; i++){
               int num=random.nextInt(10);
               nettyFastThreadLocal2[i]=new FastThreadLocal<Integer>(){
                   @Override
                   public Integer initialValue(){
                       return num;
                    }
                };
            }
        });
        thread.start();
        thread.join();
    }

    @Benchmark
    public void testJDKThreadLocal(Blackhole bh){
        for(ThreadLocal<Integer> tl: jdkThreadLocalArr){
            bh.consume(tl.get());
        }
    }

    @Benchmark
    public void testNettyFastThreadLocal(Blackhole bh){
        for(FastThreadLocal<Integer> tl: nettyFastThreadLocal){
            bh.consume(tl.get());
        }
    }

    @Benchmark
    public void testNettyFastThreadLocal2(Blackhole bh){
        for(FastThreadLocal<Integer> tl: nettyFastThreadLocal2){
            bh.consume(tl.get());
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options=new OptionsBuilder()
                .include(ThreadLocalBenchMark.class.getSimpleName())
                .build();
        new Runner(options).run();

    }
}
