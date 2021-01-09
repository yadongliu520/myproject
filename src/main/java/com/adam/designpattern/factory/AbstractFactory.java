package com.adam.designpattern.factory;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-18 08:28
 **/
public abstract  class AbstractFactory {
    public abstract <T extends IHuman> T createHuman(Class<T> classz);
}
