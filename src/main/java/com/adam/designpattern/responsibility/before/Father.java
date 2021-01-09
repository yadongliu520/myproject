package com.adam.designpattern.responsibility.before;

import com.adam.designpattern.responsibility.IWoman;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-11 22:19
 **/
public class Father implements Handler {
    @Override
    public void handleMsg(IWoman woman) {
        System.out.println("Dad, could I " + woman.getRequest() + "--yes.");
    }
}
