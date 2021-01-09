package com.adam.basic.emptyinterface;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-13 10:30
 **/
public class ValidSomething {
    private  class InnerClass implements com.adam.basic.emptyinterface.InnerClass {
        public void fun(){
            System.out.println("");
        }
    }
    public InnerClass get(){
        return new InnerClass();
    }

    public static void main(String[] args) {
        ValidSomething validSomething=new ValidSomething();
        com.adam.basic.emptyinterface.InnerClass innerClass=validSomething.get();

    }
}
