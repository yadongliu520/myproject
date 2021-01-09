package com.adam.designpattern.factory.absfactory;

import com.adam.designpattern.factory.IHuman;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 09:12
 **/
public class FemalBlackHuman3 implements IHuman {
    @Override
    public void getColor() {

    }

    @Override
    public void getTalk() {

    }

    @Override
    public void getSex() {
        System.out.println("Femal.");
    }
}
