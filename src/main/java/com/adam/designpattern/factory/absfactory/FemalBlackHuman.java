package com.adam.designpattern.factory.absfactory;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-19 09:01
 **/
public class FemalBlackHuman extends AbstractBlackHuman {
    @Override
    public void getSex(){
        System.out.println("Female.");
    }
}
