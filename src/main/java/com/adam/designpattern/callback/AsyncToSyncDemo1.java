package com.adam.designpattern.callback;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-24 15:43
 **/
public class AsyncToSyncDemo1 extends BaseDemo {
    private final Object lock = new Object();
    @Override
    public void callback(long response) {
        System.out.println("得到结果");
        System.out.println(response);
        System.out.println("调用结束");
        synchronized (lock) {
            lock.notify();
        }
    }

    public static void main(String[] args) {
        AsyncToSyncDemo1 asyncToSyncDemo1 = new AsyncToSyncDemo1();
        asyncToSyncDemo1.call();
        synchronized (asyncToSyncDemo1.lock){
            try {
                asyncToSyncDemo1.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                }
            }
        System.out.println("主线程内容");
    }
}
