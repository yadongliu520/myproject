package com.adam.anything;

import com.adam.anything.valid.Interface2;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2021-08-17 18:11
 **/
public class Class3 {
    private  Interface2 interface2;
    public Class3(Interface2 interface2){
        this.interface2=interface2;
    }
    public Interface2 getInterface(){
        return this.interface2;
    }
    public static void main(String[] args) {
        Class3 class3=new Class3(null);
        class3.getInterface().fun2();
    }
}
