package com.adam.designpattern.mediator;

import java.util.Random;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-23 08:27
 **/
public class Sale extends AbstractColleage {
    public Sale(AbstractMediator mediator) {
        super(mediator);
    }

    public void sell(int num){
        super.mediator.execute("sell", num);
    }

    public boolean getSellStatue(){ //good-true;bad-false
        Random random=new Random();
        int num1=random.nextInt(100);
        if(num1<50) return false;
        else return true;

    }

    public void offSale(int number){
        System.out.println("offSale.");
    }
}
