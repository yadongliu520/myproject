package com.adam.designpattern.bridge;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 07:51
 **/
public class HouseCorp extends Corp {
    public HouseCorp(Product product) {
        super(product);
    }

    @Override
    public void makeMoney(){
        super.makeMoney();
        System.out.println("HouseCorp makes big money");
    }
}
