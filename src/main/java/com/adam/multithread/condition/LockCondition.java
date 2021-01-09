package com.adam.multithread.condition;

import com.adam.multithread.ThreadState;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-06 14:40
 **/
public class LockCondition {
    public static void main(String[] args) {
        Thread.currentThread().setName("LockCondition");
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    condition.await();
                    System.out.println("After wait");
                }catch (Exception ignored){}
                finally {
                   lock.unlock();
                }
//                synchronized(lock){
//                    try{
//                        lock.wait();
//                        System.out.println("After wait");
//                    }catch (Exception e){}
//
//
//                }
            }
        }, "Thread-waiting");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    condition.signal();
                    //ThreadState.SleepUtils.second(20);
                    while(true);
                    //System.out.println("After signal");
                }catch (Exception e){}
                finally {
                    lock.unlock();
                }
//                synchronized (lock){
//                    try{
//                        lock.notify();
//                        ThreadState.SleepUtils.second(20);
//                        System.out.println("After notify");
//                    }catch (Exception e){}
//                }
            }

        }, "Thread-notify");

        t1.start();
        ThreadState.SleepUtils.second(1);
        t2.start();
    }
}
