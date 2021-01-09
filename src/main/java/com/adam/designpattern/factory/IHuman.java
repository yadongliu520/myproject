package com.adam.designpattern.factory;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-18 08:17
 **/
public interface IHuman {
    void getColor();
    void getTalk();
    default void getSex(){}
}
