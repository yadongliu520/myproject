package com.adam.multithread;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description:两个线程a,b。线程a锁住，线程b唤醒
 * @Author: Adam
 * @Date: 2020-08-06 09:34
 **/
public class LockSupportEx {

    private static class Thread1 implements Runnable{
        @Override
        public  void run(){
            System.out.println("Pre to Lock.");
            LockSupport.park("Thread-a");
            System.out.println("Success to Lock.");
//           synchronized (this){
//               try{
//                   System.out.println("Before wait!");
//                   this.wait();
//                   System.out.println("After wait!");
//               }catch (Exception e){
//
//               }
           }
    }



    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new Thread1(), "LockSupportEx");
        //t1.setDaemon(true);
        t1.start();
//        Thread.sleep(1000);
//        System.out.println("Befored unLock a:" + LockSupport.getBlocker(t1));
//        LockSupport.unpark(t1);
//        Thread.sleep(1000);
//        System.out.println("After unLock a:" + LockSupport.getBlocker(t1));

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Befored unLock a:" + LockSupport.getBlocker(t1));
                LockSupport.unpark(t1);
                try{
                    Thread.sleep(2000);
                }catch (Exception e){ }
                System.out.println("After unLock a:" + LockSupport.getBlocker(t1));
            }
        });
        t2.start();
    }
}
