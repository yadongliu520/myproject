package com.adam.designpattern.rule;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-04 16:01
 **/
public interface ITest {
    int a=0;
    int fun();

    static void fun2(){
        System.out.println("Do smt.");
    }

    public default void fun3(){
        System.out.println("fun3");
    }

    public default void fun4(){
        System.out.println("fun4");
    }

}
