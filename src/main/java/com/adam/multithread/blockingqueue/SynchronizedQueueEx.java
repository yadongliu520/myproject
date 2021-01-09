package com.adam.multithread.blockingqueue;

import com.adam.multithread.ThreadState;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-08 17:06
 **/
public class SynchronizedQueueEx {
    private static class Producer implements Runnable{
        BlockingQueue<String> q;
        public Producer(BlockingQueue<String> q){
            this.q=q;
        }
        @Override
        public void run(){
            for(int i=0; i<3; i++){
                String product = String.format("Product%d",i);
                try{
                    q.put(product);
                }catch (InterruptedException e){}

                System.out.println("Finished "+product);
            }
        }
    }

    private static class Consumer implements Runnable{
        BlockingQueue<String> q;
        public Consumer(BlockingQueue q){
            this.q=q;
        }

        @Override
        public void run() {
            boolean flag=true;
            while (flag){
                try{
                    String product = q.take();
                    ThreadState.SleepUtils.second(3);
                    System.out.println("Got " +product);
                }catch (Exception e){flag=false;}

            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<String> q = new SynchronousQueue<>();
        Thread p = new Thread(new Producer(q), "Pruducer-thread");
        Thread c = new Thread(new Consumer(q), "Consumer-thread");
        p.start();c.start();
    }
}
