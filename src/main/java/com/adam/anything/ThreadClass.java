package com.adam.anything;

import com.adam.multithread.ThreadState;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.ThreadPerTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-11-17 11:18
 **/
public class ThreadClass {
    public static  void createThread1(){
        Executor executor = new ThreadPerTaskExecutor(new DefaultThreadFactory(ThreadClass.class));
        for(int i=1; i<6;i++){
            int num=15;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    ThreadState.SleepUtils.second(num);
                    System.out.println(num);
                    Thread.currentThread().setName("Thread-" + num);
                }
            });
        }
    }

    public  static void createThread2(){
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for(int i=1; i<6;i++){
            int num=1;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    ThreadState.SleepUtils.second(num);
                    System.out.println(num);
                    Thread.currentThread().setName("Thread-" + num);
                }
            });
        }
    }

    public static void createThread3(){
        for(int i=1;i<6;i++){
            int num=1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadState.SleepUtils.second(num);
                    System.out.println(num);
                    Thread.currentThread().setName("Thread-" + num);
                }
            }).start();
        }
    }


    public static void main(String[] args) {
        Thread.currentThread().setName("ThreadDetector");
//        createThread1(); //运行完将退出
//        createThread2(); //线程会处于parking状态，等待condition发生，整个进程不退出
        createThread3();//运行完线程后，进程自行退出
        System.out.println("Finish thread submited ");
    }
}
