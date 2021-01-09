package com.adam.designpattern.callback;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-24 16:32
 **/
public class AsyncToSyncDemo5 extends BaseDemo {
    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    @Override
    public void callback(long response) {
        System.out.println("得到结果");
        System.out.println(response);
        System.out.println("调用结束");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AsyncToSyncDemo5 demo5 = new AsyncToSyncDemo5();
        demo5.call();
        try {
            demo5.cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("主线程内容");
    }
}
