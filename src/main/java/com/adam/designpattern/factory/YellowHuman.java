package com.adam.designpattern.factory;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-18 10:12
 **/
public class YellowHuman implements IHuman {
    @Override
    public void getColor() {
        System.out.println("Yellow.");
    }

    @Override
    public void getTalk() {
        System.out.println("Talk.");
    }
}
