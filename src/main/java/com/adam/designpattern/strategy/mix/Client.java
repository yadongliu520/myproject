package com.adam.designpattern.strategy.mix;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 11:24
 **/
public class Client {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        DeductionFacade facade=new DeductionFacade();
        facade.deduction();
    }
}
