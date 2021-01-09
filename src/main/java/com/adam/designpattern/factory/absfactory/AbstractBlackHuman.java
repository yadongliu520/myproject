package com.adam.designpattern.factory.absfactory;

import com.adam.designpattern.factory.IHuman;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-19 08:58
 **/
public abstract class AbstractBlackHuman  {
    public void getColor() {
        System.out.println("Black.");
    }

    public void getTalk() {
        System.out.println("Talk");
    }
    public abstract void getSex();
}
