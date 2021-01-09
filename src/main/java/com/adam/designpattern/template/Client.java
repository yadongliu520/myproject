package com.adam.designpattern.template;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 14:39
 **/
public class Client {
    public static void main(String[] args) {
        Hummer hummer1=new HummerModel1();
        hummer1.run();
        Hummer hummer2=new HummerModel2();
        hummer2.run();
    }
}
