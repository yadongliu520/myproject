package com.adam.anything;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-11-22 08:05
 **/
public class ChainReturnSelf<C extends ChainReturnSelf> {
    public  C self(){
        return (C)this;
    }

    public C fun1(){
        System.out.println("fun1");
        return self();
    }

    public C fun2(){
        System.out.println("fun2");
        return self();
    }

    public static void main(String[] args) {
        ChainReturnSelf chainReturnSelf =new ChainReturnSelf();
        chainReturnSelf.fun1().fun2();
    }
}
