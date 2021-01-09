package com.adam.designpattern.callback;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-24 16:16
 **/
public class AsyncToSyncDemo3 {
    private AsyncCall asyncCall = new AsyncCall();
    public Future<Long> call(){
        Future<Long> future = asyncCall.futureCall();
        asyncCall.shutdown();
        return future;
    }

    public static void main(String[] args) {
        AsyncToSyncDemo3 demo3 = new AsyncToSyncDemo3();
        System.out.println("发起调用");
        Future<Long> future = demo3.call();
        System.out.println("返回结果");
        if (!future.isDone() && !future.isCancelled());
        try {
            System.out.println("得到结果");
            System.out.println(future.get());//会发生阻塞
            System.out.println("调用结束");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("主线程内容");
    }
}
