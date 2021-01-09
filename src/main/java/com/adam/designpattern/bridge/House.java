package com.adam.designpattern.bridge;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 07:57
 **/
public class House extends Product {
    @Override
    public void beProducted() {
        System.out.println("Product of house");
    }

    @Override
    public void beSelled() {
        System.out.println("Selled house");
    }
}
