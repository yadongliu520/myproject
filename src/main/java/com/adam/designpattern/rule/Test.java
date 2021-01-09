package com.adam.designpattern.rule;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-04 16:12
 **/
public class Test implements ITest{


//    public int fun() {
//        return 0;
//    }

    public static void main(String[] args) {
        ITest test= new ITest() {
            @Override
            public int fun() {
                return 0;
            }
        };
        test.fun3();
        ITest.fun2();
        System.out.println("");
    }

    @Override
    public int fun() {
        return 0;
    }
}
