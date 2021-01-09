package com.adam.designpattern.builder;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-21 00:26
 **/
public class Client2 {
    public static void main(String[] args) {
        Director director=new Director();
        director.getCarBuilder(1).getCarModel().run();
        director.getCarBuilder(2).getCarModel().run();

        Director2 director2=new Director2();
        director2.getBenzModel().run();
        director2.getBwmModel().run();
    }

}
