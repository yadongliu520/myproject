package com.adam.designpattern.callback;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-24 16:26
 **/
public class AsyncToSyncDemo4 extends BaseDemo{
    private final CountDownLatch countDownLatch = new CountDownLatch(1);
    private final CountDownLatch countDownLatch2=new CountDownLatch(1);

    @Override
    public void callback(long response) {
        System.out.println("得到结果");
        System.out.println(response);
        System.out.println("调用结束");
        countDownLatch.countDown();
    }

    public static void main(String[] args) {
        AsyncToSyncDemo4 demo4 = new AsyncToSyncDemo4();
        demo4.call();
        try {
            demo4.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程内容");
    }
}
