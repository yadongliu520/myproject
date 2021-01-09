package com.adam.designpattern.servant;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-05 08:38
 **/
public class Kitchen implements Cleanable {
    @Override
    public void cleaned() {
        System.out.println("Kitchen was cleaned");
    }
}
