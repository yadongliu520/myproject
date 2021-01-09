package com.adam.designpattern.template;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 16:07
 **/
public class HummerModel2 extends Hummer{
    @Override
    protected void alarm() {
        System.out.println("HummerModel2 alarm.");
    }

    @Override
    protected void boom() {
        System.out.println("HummerModel2 boom.");
    }

    @Override
    protected void start() {
        System.out.println("HummerModel2 start.");
    }

    @Override
    protected void stop() {
        System.out.println("HummerModel2 stop.");
    }

    @Override
    protected boolean isAlarm(){
        return false;
    }
}
