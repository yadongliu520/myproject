package com.adam.designpattern.builder;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 23:36
 **/
public class BwmBuilder extends CarBuilder {
    @Override
    public ArrayList<String> getSeq() {
        ArrayList<String> seq=new ArrayList<>();
        seq.add("start");
        seq.add("alarm");
        seq.add("boom");
        seq.add("stop");
        return seq;
    }

    @Override
    public CarModel getCarModel() {
        return new BwmModel();
    }
}
