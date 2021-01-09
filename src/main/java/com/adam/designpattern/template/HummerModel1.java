package com.adam.designpattern.template;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 14:36
 **/
public class HummerModel1 extends Hummer {
    @Override
    protected void alarm() {
        System.out.println("HummerModel1 alarm.");
    }

    @Override
    protected void boom() {
        System.out.println("HummerModel1 boom.");
    }

    @Override
    protected void start() {
        System.out.println("HummerModel1 start.");
    }

    @Override
    protected void stop() {
        System.out.println("HummerModel1 stop");
    }
}
