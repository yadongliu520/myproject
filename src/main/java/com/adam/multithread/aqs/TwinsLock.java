package com.adam.multithread.aqs;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-05 11:56
 **/
public class TwinsLock implements Lock {
    private final Sync sync = new Sync(2);
    private static final class Sync extends AbstractQueuedSynchronizer{
        Sync(int count){
            if(count<=0) throw new IllegalArgumentException("count must large than zero.");
            setState(count);
        }
        public int tryAcquireShared(int reduceCount){
            for(;;){
                int current =getState();
                int newCount =current-reduceCount;
                //if(newCount<0||compareAndSetState(current, newCount))return newCount;
                if(newCount<=0) return 0;
                if(compareAndSetState(current, newCount))return 1;
            }
        }

        public boolean tryReleaseShared(int returnCount){
            for(;;){
               int current =getState();
               int newCount =current +returnCount;
               if(compareAndSetState(current, newCount)) return true;
            }
        }
    }



    @Override
    public void lock() {
        sync.tryAcquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquireShared(1)==1?true:false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.tryReleaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}


