package com.adam.designpattern.adapter;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-25 14:54
 **/
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.doSmt();
        System.out.println("Finished adapte.");
    }
}
