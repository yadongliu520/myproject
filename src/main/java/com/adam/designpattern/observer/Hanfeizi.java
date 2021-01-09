package com.adam.designpattern.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-07 22:29
 **/
public class Hanfeizi implements IHanfeizi {
    private final Vector vector=new Vector();
//    private  static final ArrayBlockingQueue queue=new ArrayBlockingQueue(10);
//    private LinkedBlockingQueue queue2= new LinkedBlockingQueue();
//    private LinkedTransferQueue queue3=new LinkedTransferQueue();
    private ExecutorService pool= Executors.newFixedThreadPool(2);
    private AtomicInteger index=new AtomicInteger(0);
    private void asyncNotifyObservers(Object arg){
        while (index.get()<vector.size()){
            IObserver o=this.detach(index.getAndIncrement());
            pool.execute(()->{
                o.update(arg);
            });
        }
        index.set(0);
    }

    public void attach(IObserver o){
        vector.add(o);
    }

    public IObserver detach(int index){
        return  (IObserver) vector.get(index);
    }

    public void threadShutDown(){
        pool.shutdown();
    }

    @Override
    public void haveBreakfast() {
        System.out.println("Hanfeizi is prepare to eat.");
        this.asyncNotifyObservers("Hanfeizi is having breakfast.");
    }

    @Override
    public void haveFun() {
        System.out.println("Hanfeizi is prepare to have fun.");
        this.asyncNotifyObservers("Hanfeizi is having fun");

    }

}
