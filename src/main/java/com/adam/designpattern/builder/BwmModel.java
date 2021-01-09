package com.adam.designpattern.builder;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 22:55
 **/
public class BwmModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("Bwm start.");
    }

    @Override
    protected void alarm() {
        System.out.println("Bwm alarm.");
    }

    @Override
    protected void boom() {
        System.out.println("bwm boom.");
    }

    @Override
    protected void stop() {
        System.out.println("Bwm stop.");
    }
}
