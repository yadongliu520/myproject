package com.adam.designpattern.factory;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-18 08:17
 **/
public class WhiteHuman implements IHuman {
    @Override
    public void getColor() {
        System.out.println("White.");
    }

    @Override
    public void getTalk() {
        System.out.println("Talk");
    }

}
