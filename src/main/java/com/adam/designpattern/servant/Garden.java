package com.adam.designpattern.servant;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-05 08:37
 **/
public class Garden implements Cleanable {
    @Override
    public void cleaned() {
        System.out.println("Garden was clened");
    }
}
