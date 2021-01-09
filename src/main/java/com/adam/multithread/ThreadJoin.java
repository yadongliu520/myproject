package com.adam.multithread;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-07-27 23:24
 **/
public class ThreadJoin {
    ArrayList<Thread> arr = new ArrayList<Thread>();
    public void createThreadArr(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 output!");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread2 output!");
            }
        });
         Thread t3 = new Thread(new Runnable(){
             @Override
             public void run(){
                 System.out.println("Thread3 output!");
             }
         });

            arr.add(t1);
            arr.add(t2);
            arr.add(t3);
        }

        public static void main(String[] args) throws InterruptedException {
            ThreadJoin tj = new ThreadJoin();
            tj.createThreadArr();
            for(Thread t: tj.arr){
                t.start();
                t.join();
            }
            System.out.println("Main Thread Finished!");
        }
    }


