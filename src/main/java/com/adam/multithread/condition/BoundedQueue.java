package com.adam.multithread.condition;

import com.adam.multithread.ThreadState;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-06 15:50
 **/
public class BoundedQueue<T> {
    LinkedList<T> queue = new LinkedList<>();
    int queueSizeLimit=1;
    Lock lock=new ReentrantLock();
    Condition notFull =lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public void add(T o){
        lock.lock();
        try{
            while(queue.size() == queueSizeLimit){
                System.out.println("To limit, waiting empty.");
                notFull.await();
            }
            queue.add(o);
            notEmpty.signal();
            System.out.println("signal notempty");
        }catch (Exception e){}
        finally {
            lock.unlock();
        }
    }

    public T remove(){
        lock.lock();
        T o=null;
        try{
            while (queue.size()==0){
                System.out.println("empty, wait to notempty");
                notEmpty.await();
            }
            o = queue.removeLast();
            notFull.signal();
            System.out.println("signal notFull");
        }catch (Exception e){}
        finally {
            lock.unlock();
        }
        return o;
    }

    public static void main(String[] args) {
        BoundedQueue q = new BoundedQueue();
        Thread addT =new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(true){
                    q.add(i++);
                    ThreadState.SleepUtils.second(1);
                }
            }
        }, "Add-thread");

        Thread removeT = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    q.remove();
                    ThreadState.SleepUtils.second(1);
                }

            }
        }, "Remove-thread");

        addT.start();
        removeT.start();
    }
}
