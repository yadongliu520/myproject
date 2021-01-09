package com.adam.designpattern.builder;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 23:37
 **/
public class Client {
    public static void main(String[] args) {
        CarBuilder benzBuilder=new BenzBuilder();
        CarBuilder bwmBuilder=new BwmBuilder();
        CarModel benzModel= benzBuilder.getCarModel();
        benzModel.setSeq(benzBuilder.getSeq());
        CarModel bwmMode=bwmBuilder.getCarModel();
        bwmMode.setSeq(bwmBuilder.getSeq());

        benzModel.run();
        bwmMode.run();

    }


}
