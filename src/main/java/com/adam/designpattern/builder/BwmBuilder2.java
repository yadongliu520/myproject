package com.adam.designpattern.builder;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 23:36
 **/
public class BwmBuilder2 extends CarBuilder2{
    private ArrayList<String> seq;
    private CarModel carModel;
    public BwmBuilder2(ArrayList<String> seq){
        this.seq=seq;
        this.carModel=new BwmModel();
        this.getCarModel().setSeq(seq);
    }

//    @Override
//    public ArrayList<String> getSeq() {
//        return this.seq;
//    }

//    @Override
//    public void setSeq(ArrayList<String> seq) {
//        this.seq=seq;
//    }

    @Override
    public CarModel getCarModel() {
        //CarModel model=new BwmModel();
        //model.setSeq(seq);
        return carModel;
    }
}
