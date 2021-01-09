package com.adam.multithread;

import com.sun.rmi.rmid.ExecOptionPermission;

import java.util.concurrent.CyclicBarrier;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-09 17:20
 **/
public class CyclicBarrierEx {
    static CyclicBarrier c1 =new CyclicBarrier(1);
    static CyclicBarrier c2=new CyclicBarrier(5,()->{
        System.out.println("All threads are ready, Go!");
    });

    public static void main(String[] args) {
        Thread t=new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    c1.await();
                    System.out.println("1");
                }catch (Exception e){}


            }
        });
        t.start();
        System.out.println("2");

        for(int i=0;i<5;i++){
            Thread t1=new Thread(()->{

                try {
                    System.out.println(Thread.currentThread().getName() + " is prepare!");
                    c2.await();
                    System.out.println(Thread.currentThread().getName() + " has finished!");
                }catch (Exception e){}

            }, String.format("Thread-%d", i));
            t1.start();
        }
    }
}
