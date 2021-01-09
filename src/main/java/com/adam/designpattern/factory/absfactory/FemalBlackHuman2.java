package com.adam.designpattern.factory.absfactory;

import com.adam.designpattern.factory.IHuman;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 09:00
 **/
public class FemalBlackHuman2 implements IHuman,ISex {

    @Override
    public void getColor() {
        System.out.println("Black.");
    }

    @Override
    public void getTalk() {
        System.out.println("Talk.");
    }

    @Override
    public void getSex() {
        System.out.println("Femal.");
    }
}
