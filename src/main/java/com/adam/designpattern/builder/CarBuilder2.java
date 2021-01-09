package com.adam.designpattern.builder;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 22:56
 **/
public abstract  class CarBuilder2 {
    public  ArrayList<String> getSeq(){return null;};
    public  void setSeq(ArrayList<String> seq){};
    public abstract  CarModel getCarModel();
}
