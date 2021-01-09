package com.adam.designpattern.builder;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-21 00:13
 **/
public class Director {
    private int carType;
    ArrayList<String> seq=new ArrayList<>();
    public CarBuilder2 getCarBuilder(int carType){
        CarBuilder2 builder2=null;
        switch (carType){
            case 1:{
                seq.clear();
                seq.add("start");
                seq.add("boom");
                seq.add("alarm");
                seq.add("stop");
                builder2=new BenzBuilder2(seq);
                break;
            }
            case 2:{
                seq.clear();
                seq.add("start");
                seq.add("alarm");
                seq.add("boom");
                seq.add("stop");
                builder2 =new BwmBuilder2(seq);
                break;
            }
            default:{
                System.out.println("No carType");
            }
        }
        return builder2;
    };
}
