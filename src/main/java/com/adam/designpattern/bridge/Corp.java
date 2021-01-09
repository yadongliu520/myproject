package com.adam.designpattern.bridge;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 07:50
 **/
public abstract class Corp {
    private Product product;
    public Corp(Product product){
        this.product=product;
    }

    public void makeMoney(){
        this.product.beProducted();
        this.product.beSelled();
    }
}
