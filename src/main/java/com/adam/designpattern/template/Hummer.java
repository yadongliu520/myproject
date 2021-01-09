package com.adam.designpattern.template;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 14:31
 **/
public abstract class Hummer  {
    protected abstract void alarm();
    protected abstract void boom();
    protected abstract void start();
    protected abstract void stop();
    public  final void run(){
        this.start();
        if(isAlarm()){
            this.alarm();
        }
        this.boom();
        this.stop();
    }

    protected boolean isAlarm(){
        return true;
    }
}
