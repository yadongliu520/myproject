package com.adam.designpattern.observer;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-07 23:10
 **/
public class Handler implements Runnable{
    private Observable observable;
    private String msg;
    public Handler(Observable observable, String msg){
        this.observable=observable;
        this.msg=msg;
    }

    public void run(Observer observer){
        observer.update(observable, msg);
    }

    @Override
    public void run() {

    }
}
