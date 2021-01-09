package com.adam.multithread.something;

import com.adam.multithread.ThreadState;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-30 18:46
 **/
public class Example1 {
    public static class Task{
        private  AtomicInteger i=new AtomicInteger(0);
        public  void run(){
            while (true){
                System.out.println(Thread.currentThread().getName() + ": " + i.addAndGet(1));
                ThreadState.SleepUtils.second(1);
            }

         }
    }

    public static void main(String[] args) {
        ExecutorService threadPool= Executors.newFixedThreadPool(3);
        Example1 example1=new Example1();
        Task task= new Task();
        for(int i=0;i<3;i++){
            threadPool.execute(()->{
                 task.run();
                 task.run();
            });
        }
    }
}
