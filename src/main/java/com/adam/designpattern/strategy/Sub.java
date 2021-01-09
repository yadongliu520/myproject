package com.adam.designpattern.strategy;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-08 23:52
 **/
public class Sub implements Calculator {
    @Override
    public int exec(int a, int b) {
        return a-b;
    }
}
