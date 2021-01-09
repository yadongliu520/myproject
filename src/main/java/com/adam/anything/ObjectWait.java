package com.adam.anything;

import com.adam.multithread.ThreadState;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-12-04 07:55
 **/
public class ObjectWait {
        Object lock=new Object();
        int waiter=0;
        public  void wait1() throws InterruptedException {
            synchronized (lock){
                ++waiter;
                lock.wait();
                System.out.println("==Wait: " + waiter);
            }
        }

        public void notify1(){
            synchronized (lock){
                lock.notifyAll();
            }
        }

    public static void printThradInfo(Thread thred){
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        Map < Thread, StackTraceElement[] > traceMap = thred.getAllStackTraces();
        Set< Thread > allThreads = traceMap.keySet();
        for (Thread thread: allThreads) {
            StringBuilder msg = new StringBuilder();
            long tid = thread.getId();
            ThreadInfo threadInfo = bean.getThreadInfo(tid);
            if(threadInfo == null){
                continue;
            }
            String lockInfo = threadInfo.getLockName() == null ? " " : ", " + threadInfo.getLockName();
            msg.append("thread id: " + tid + ", name: " + threadInfo.getThreadName() + ", " + threadInfo.getThreadState() + lockInfo).append("\n");
            StackTraceElement[] stackTraces = thread.getStackTrace();
            for (StackTraceElement stackTrace: stackTraces) {
                msg.append("\t").append(stackTrace).append("\n");
            }
            System.out.println(msg);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ObjectWait wait=new ObjectWait();
        new Thread(()->{
            try {
                wait.wait1();
                System.out.println("After wait, got lock.");
                wait.printThradInfo(Thread.currentThread());
                ThreadState.SleepUtils.second(20);
            }catch(Exception e){
                e.printStackTrace();
            }
        }, "wait").start();
        //ThreadState.SleepUtils.second(1);
        new Thread(()->{
            System.out.println("Got Monitor lock.");
            ThreadState.SleepUtils.second(60);
            wait.notify1();
        },"notify").start();

        System.out.println("Finished.");

    }
}
