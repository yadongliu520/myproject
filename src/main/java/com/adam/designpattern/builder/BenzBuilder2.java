package com.adam.designpattern.builder;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 23:33
 **/
public class BenzBuilder2 extends CarBuilder2 {
    private ArrayList<String> seq;
    private CarModel carModel;
    public BenzBuilder2(ArrayList<String> seq){
        this.seq=seq;
        this.carModel=new BenzModel();
        this.carModel.setSeq(seq);
    }

//    @Override
//    public ArrayList<String> getSeq() {
//        return this.seq;
//    }

//    @Override
//    public void setSeq(ArrayList<String> seq) {
//        this.getCarModel().setSeq(seq);
//    }

    @Override
    public CarModel getCarModel() {
        //CarModel model=new BenzModel();
        //model.setSeq(seq);
        return this.carModel;
    }
}
