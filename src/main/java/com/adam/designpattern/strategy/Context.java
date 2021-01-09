package com.adam.designpattern.strategy;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-08 23:52
 **/
public class Context {
    private Calculator cal;
    public Context set(Calculator cal){
        this.cal=cal;
        return this;
    }
    public int exec(int a, int b){
        return cal.exec(a,b);
    }
}
