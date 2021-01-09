package com.adam.anything.valid;

import java.beans.Introspector;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-17 09:57
 **/
public class Class1 extends AbsClass{

    @Override
    public void func1() {
        System.out.println("func1 in Class1");
    }

    @Override
    protected void func2() {

    }


    @Override
    public <T extends InterfaceDemo> T func4() {
        return null;
    }

    public void func5(){
        super.func3(); //父类中func3调用了抽象方法func1，在该子类中实现
    }

    public static void main(String[] args) {
        Class1 class1=new Class1();
        class1.func5();
    }
}
