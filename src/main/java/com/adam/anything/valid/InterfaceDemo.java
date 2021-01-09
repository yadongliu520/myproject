package com.adam.anything.valid;

import com.adam.designpattern.factory.absfactory.AbstractBlackHuman;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-17 09:54
 **/
public interface InterfaceDemo {
     String a=""; //默认是final static 类型
     void func1();
     void func2();
     default void func3(){
          System.out.println("Default.");
     }

     public static void main(String[] args) {
          String b=InterfaceDemo.a; //
     }
}
