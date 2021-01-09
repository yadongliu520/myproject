package com.adam.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-03 11:48
 **/
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch latch = new CountDownLatch(5);
        final Service service = new Service(latch);
        Runnable task = () -> service.exec();
        for(int i =0; i <5; i++){
            Thread thread = new Thread(task);
            thread.start();
        }
        System.out.println("main thread wait");
        latch.await();
        System.out.println("main thread finished wait");

    }
    public static class Service{
        private CountDownLatch latch;
        public Service(CountDownLatch latch){
            this.latch =latch;
        }
        public void exec() {
            try{
                System.out.println(Thread.currentThread().getName() + " start task.");
                ThreadState.SleepUtils.second(10);
                System.out.println(Thread.currentThread().getName() + " finished task.");
            }finally {
                latch.countDown();
            }
        }
    }
}
