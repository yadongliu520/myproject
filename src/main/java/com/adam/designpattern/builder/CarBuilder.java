package com.adam.designpattern.builder;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 22:56
 **/
public abstract  class CarBuilder {
    public abstract  ArrayList<String> getSeq();
    public abstract  CarModel getCarModel();
}
