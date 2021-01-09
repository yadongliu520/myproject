package com.adam.designpattern.builder;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 22:42
 **/
public class BenzModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("Benz start.");
    }

    @Override
    protected void alarm() {
        System.out.println("Benz alarm.");
    }

    @Override
    protected void boom() {
        System.out.println("Benz boom.");
    }

    @Override
    protected void stop() {
        System.out.println("Benz stop.");
    }


}
