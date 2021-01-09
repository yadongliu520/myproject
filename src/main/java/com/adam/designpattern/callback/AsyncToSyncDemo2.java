package com.adam.designpattern.callback;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-24 16:08
 **/
public class AsyncToSyncDemo2 extends BaseDemo {
    private final Lock lock = new ReentrantLock();
    private final Condition con = lock.newCondition();

    private final Lock lock2 =new ReentrantLock();
    private final Condition condition=lock.newCondition();
    @Override
    public void callback(long response) {
        System.out.println("得到结果");
        System.out.println(response);
        System.out.println("调用结束");
        lock.lock();
        try {
            con.signal();
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        AsyncToSyncDemo2 demo2 = new AsyncToSyncDemo2();
        demo2.call();
        demo2.lock.lock();
        try {
            demo2.con.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            demo2.lock.unlock();
        }
        System.out.println("主线程内容");
    }
}

