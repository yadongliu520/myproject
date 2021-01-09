package com.adam.designpattern.factory;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-18 08:43
 **/
public class Client {
    public static void main(String[] args) {
        AbstractFactory factory =new Factory();
        IHuman whiteHuman=factory.createHuman(WhiteHuman.class);
        IHuman yellowHuman=factory.createHuman(YellowHuman.class);
        IHuman blackHuman=SimpleFactory.createHuman(BlackHuman.class);

        IFactory factory2=new BlackHumanFactory();
        IHuman blackHuman2=factory2.createHuman();

        whiteHuman.getColor();
        whiteHuman.getTalk();
        yellowHuman.getColor();
        yellowHuman.getTalk();
        blackHuman.getColor();
        blackHuman.getTalk();
        blackHuman2.getColor();
        blackHuman2.getTalk();
    }
}
