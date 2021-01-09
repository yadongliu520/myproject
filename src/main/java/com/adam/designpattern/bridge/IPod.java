package com.adam.designpattern.bridge;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 07:48
 **/
public class IPod extends Product {

    @Override
    public void beProducted() {
        System.out.println("Product of iPod");
    }

    @Override
    public void beSelled() {
        System.out.println("Selled iPod");
    }
}
