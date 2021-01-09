package com.adam.designpattern.bridge;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 07:54
 **/
public class ShanZhaiCorp extends Corp {
    public ShanZhaiCorp(Product product) {
        super(product);
    }
    @Override
    public void makeMoney(){
        super.makeMoney();
        System.out.println("ShanzhaiCorp makes money");
    }
}
