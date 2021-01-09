package com.adam.designpattern.factory.absfactory;

import com.adam.designpattern.factory.IHuman;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 09:14
 **/
public class MaleBlackHuman3 implements IHuman {
    @Override
    public void getColor() {
        System.out.println("Color");
    }

    @Override
    public void getTalk() {
        System.out.println("Talk.");
    }

    @Override
    public void getSex() {
        System.out.println("Male.");
    }
}
