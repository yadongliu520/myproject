package com.adam.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-09 17:57
 **/
public class SemaphoreEx {
    static class  Task implements Runnable{
        Semaphore s;
        public Task(Semaphore s){
            this.s =s;
        }

        @Override
        public void run() {
            try{
                while(true){
                    s.acquire();
                    //System.out.println(Thread.currentThread().getName() + " is working.");
                    System.out.println(Thread.currentThread().getName() + " has done.");
                    System.out.println("Next batch is prepare.");
                    ThreadState.SleepUtils.second(10);
                    s.release();

                }

            }catch (Exception e){}
        }
    }

    static class MyThread implements ThreadFactory{
        String name;
        public MyThread( String name){
            this.name=name;
        }
        @Override
        public Thread newThread(Runnable r) {
            System.out.println(name);
            return  new Thread(r,name);
        }
    }

    public static void main(String[] args) {
        ExecutorService servive = Executors.newFixedThreadPool(5);
        Semaphore s=new Semaphore(3);
        for(int i=0;i<5;i++){
            Task task = new Task(s);
            Thread t=new MyThread(String.format("Thread-%d",i)).newThread(task);
            //Thread t=new Thread(task,  String.format("Thread-%d",i));
            servive.execute(t);
        }
        servive.shutdown();
    }
}
