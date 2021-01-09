package com.adam.multithread;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-07-27 19:44
 **/

public class SynchronizedExample {
    int a=0;
    boolean flag=false;
    public synchronized void writer(){
        a=1;
        flag=true;
    }

    public synchronized void reader(){
        if(flag){
            a=2;
        }
        System.out.println(String.format("a= %s", a));
    }

    public static void main(String[] args) {
        final   SynchronizedExample ex=new SynchronizedExample();
//        ex.writer();
//        ex.reader();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ex.writer();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ex.reader();
            }
        });
        t1.start();
        t2.start();
    }

}
