package com.adam.designpattern.factory.absfactory;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-19 09:03
 **/
public class MaleBlackHuman extends AbstractBlackHuman {
    @Override
    public void getSex(){
        System.out.println("Male.");
    }
}
