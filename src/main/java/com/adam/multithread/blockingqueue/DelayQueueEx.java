package com.adam.multithread.blockingqueue;

import com.adam.multithread.ThreadState;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-08 12:16
 **/
public class DelayQueueEx {
    private static  class DelayItem implements Delayed{
        int value;
        long startTime;
        long expireTime =2000;
        public DelayItem(long startTime, int value){
            this.startTime = startTime;
            this.value =value;
        }

        @Override
        public long getDelay(TimeUnit uint) {
            return expireTime-(System.currentTimeMillis() - startTime) ;
        }

        @Override
        public int compareTo(Delayed o) {
            DelayItem item =(DelayItem)o;
            return  this.startTime<item.startTime?1:-1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayItem> q=new DelayQueue<>();
        for(int i=0;i<5;i++){
            DelayItem item =new DelayItem(System.currentTimeMillis(), i);
            ThreadState.SleepUtils.second(1);
            q.put(item);
        }
        while(q.peek()!=null){
            DelayItem item = q.take();
            System.out.println("Delay time: " + item.getDelay(TimeUnit.MILLISECONDS));
            System.out.println(item.value);
        }
    }
}
