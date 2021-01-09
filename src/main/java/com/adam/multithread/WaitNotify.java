package com.adam.multithread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-02 10:08
 **/
public class WaitNotify {
    static Object lock =new Object();
    static  boolean flag =true;
    public static void main(String[] args){

        Thread wait = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(lock){
                    while(flag){
                        System.out.println("flag is true," + Thread.currentThread().getName() + " Waiting @"
                                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        try{
                            lock.wait();
                            ThreadState.SleepUtils.second(10);
                            System.out.println("flag is true," + Thread.currentThread().getName() + " Waited @"
                                    + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        }catch (InterruptedException e){
                        }
                    }
                    System.out.println("flag is false, " + Thread.currentThread() + " running @" +
                            new SimpleDateFormat("HH:mm:ss").format(new Date()));
                }
            }
        }, "WaitThread");

        Thread notify = new Thread(new Notify(),"NotifyThread");
        wait.start();
        notify.start();
        ThreadState.SleepUtils.second(1);

    }

    private static class Notify implements Runnable{
        @Override
        public void run(){
            synchronized(lock){
                System.out.println(Thread.currentThread() + " flag is true, hold lock @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                ThreadState.SleepUtils.second(10);
                lock.notifyAll();
                flag =false;
                System.out.println(Thread.currentThread() + " flage is false, hold lock @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                ThreadState.SleepUtils.second(10);
            }
//            synchronized(lock){
//                System.out.println(Thread.currentThread() + " hold lock again @"
//                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
//                ThreadState.SleepUtils.second(3);
//            }
        }
    }
}
