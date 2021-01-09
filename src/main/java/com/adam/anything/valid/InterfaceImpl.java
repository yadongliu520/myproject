package com.adam.anything.valid;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-17 09:55
 **/
public class InterfaceImpl implements InterfaceDemo{

    @Override
    public void func1() {

    }

    @Override
    public void func2() {

    }

    public static void main(String[] args) {
        String s=null;
        s=null;
        System.out.println(s);
    }
    
    public <T extends Object> T fun(){
         T t = null;
        return t;
    }
}
