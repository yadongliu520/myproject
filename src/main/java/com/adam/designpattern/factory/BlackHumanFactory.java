package com.adam.designpattern.factory;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-18 18:00
 **/
public class BlackHumanFactory implements IFactory {
    @Override
    public BlackHuman  createHuman() {
        return new BlackHuman();
    }
}
