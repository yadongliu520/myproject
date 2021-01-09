package com.adam.multithread.aqs;
import com.adam.multithread.ThreadState;
import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-05 14:45
 **/
public class TwinsLockTest {
    @Test
    public void test(){
        final Lock lock=new TwinsLock();
        class Worker extends Thread{
            public void run(){
                while(true){
                    lock.tryLock();
                    try{
                        System.out.println(Thread.currentThread().getName());
                        ThreadState.SleepUtils.second(3);
                    }finally {
                      lock.unlock();
                    }
                }
            }
        }
        for(int i=0;i<4;i++){
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }

        //for(int i=0;i<3;i++){
            ThreadState.SleepUtils.second(5);
            System.out.println();
        //}
    }

}
