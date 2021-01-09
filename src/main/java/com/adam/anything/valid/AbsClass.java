package com.adam.anything.valid;

import com.adam.designpattern.factory.IHuman;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-17 09:56
 **/
public abstract  class AbsClass implements Interface2{
    public AbsClass(){}
    protected abstract void func1();
    protected abstract void func2();
    protected  void func3(){
        func1();
    };
    public abstract <T extends InterfaceDemo> T func4();

    @Override
    public void function1(){
        System.out.println("");
    };
    @Override
    public void fun2(){}
}
