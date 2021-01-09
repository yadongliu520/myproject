package com.adam.designpattern.builder;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 23:33
 **/
public class BenzBuilder extends CarBuilder {
    @Override
    public ArrayList<String> getSeq() {
        ArrayList<String> seq=new ArrayList<>();
        seq.add("start");
        seq.add("boom");
        seq.add("alarm");
        seq.add("stop");
        return seq;
    }

    @Override
    public CarModel getCarModel() {
        return new BenzModel();
    }
}
