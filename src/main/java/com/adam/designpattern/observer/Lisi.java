package com.adam.designpattern.observer;

import com.adam.multithread.ThreadState;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-07 22:26
 **/
public class Lisi implements IObserver {
    @Override
    public void update(Object arg) {
        //ThreadState.SleepUtils.second(3);
        System.out.println("Lisi got it." + arg.toString());
    }
}
