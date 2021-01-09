package com.adam.multithread.aqs;

import com.adam.multithread.ThreadState;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-05 16:15
 **/
public class FairAndUnFairLockTest {
    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unFairLock = new ReentrantLock2(false);
    @Test
    public void fair(){
        testLock(fairLock);
    }
    @Test
    public void unfair(){
        testLock(unFairLock);
    }
    private  void testLock(Lock lock){
        for(int i=0;i<5;i++){
            Job job =new Job(lock);
            job.setName(String.format("%d",i));
            job.start();
            //ThreadState.SleepUtils.second(1);
        }

    }
    private static class Job extends Thread{
        private Lock lock;
        private ReentrantLock2 lock2;
        public Job(Lock lock){
            this.lock = lock;
            this.lock2 = (ReentrantLock2)lock;
        }
        public void run(){
            try{
                lock.lock();
                String  waitingThreaNum = StringUtils.join(lock2.getQueuedThreads().stream().map(x -> x.getName()).toArray(), ",");
                System.out.println(String.format("Lock by [%s], waiting by[%s]", Thread.currentThread().getName(),waitingThreaNum));
                System.out.println(lock2.getQueuedThreads().size() );
                //ThreadState.SleepUtils.second(1);
            }finally {
                lock.unlock();
            }
        }
    }

    private static class ReentrantLock2 extends ReentrantLock{
        public ReentrantLock2(boolean fair){
            super(fair);
        }
        public Collection<Thread> getQueuedThreads(){
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return  arrayList;
        }
    }


}
