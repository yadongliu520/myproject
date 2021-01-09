package com.adam.designpattern.servant;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-05 08:39
 **/
public class Cloth implements Cleanable {
    @Override
    public void cleaned() {
        System.out.println("Cloth was cleaned");
    }
}
