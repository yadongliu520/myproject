package com.adam.multithread;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-07-31 23:09
 **/
public class ThreadState {
    public static class SleepUtils{
        public static final void second(long seconds){
            try {
                TimeUnit.SECONDS.sleep(seconds);
            }catch (InterruptedException e){

            }
        }
    }
    public static class TimeWaiting implements Runnable{
        @Override
        public void run(){
            //while (true){
                SleepUtils.second(30);
                System.out.println(Thread.currentThread().getName() + " is OK!");
            //}
        }
    }
     static class Waiting implements Runnable{
        @Override
        public void run(){
            while(true){
                synchronized(Waiting.class){
                    try{
                        Waiting.class.wait();
                    }catch (InterruptedException e){
                    }
                }
            }
        }
    }

    static class Blocked implements  Runnable{
        @Override
        public void run(){
            synchronized(Blocked.class){
                //while(true){
                    SleepUtils.second(30);
                System.out.println(Thread.currentThread().getName() + " is OK !!");
                //}
            }
        }
    }

    public static void main(String[] args){
        new Thread(new TimeWaiting(), "TImeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        new Thread(new Blocked(), "BlockedThread1").start();
        new Thread(new Blocked(), "BlockedThread2").start();

    }

}
