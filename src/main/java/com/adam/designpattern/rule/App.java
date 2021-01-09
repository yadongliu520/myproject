package com.adam.designpattern.rule;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-04 17:10
 **/
public class App {
    public static void main(String[] args) {
        int a=0;
        AbstractTest abstractTest=new AbstractTest(a) {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
    }
}
