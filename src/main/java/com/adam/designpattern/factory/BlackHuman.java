package com.adam.designpattern.factory;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-18 10:17
 **/
public class BlackHuman implements IHuman {
    @Override
    public void getColor() {
        System.out.println("Black.");
    }

    @Override
    public void getTalk() {
        System.out.println("Talk.");
    }
}
