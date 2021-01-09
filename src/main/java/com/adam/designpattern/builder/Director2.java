package com.adam.designpattern.builder;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-21 00:13
 **/
public class Director2 {
    ArrayList<String> seq=new ArrayList<>();
    CarBuilder2 carBuilder2;
    public CarModel getBenzModel(){
        seq.clear();
        seq.add("start");
        seq.add("boom");
        seq.add("alarm");
        seq.add("stop");
        this.carBuilder2=new BenzBuilder2(seq);
        return carBuilder2.getCarModel();
    }

    public CarModel getBwmModel(){
        seq.clear();
        seq.add("start");
        seq.add("alarm");
        seq.add("boom");
        seq.add("stop");
        this.carBuilder2=new BwmBuilder2(seq);
        return carBuilder2.getCarModel();
    }
}
