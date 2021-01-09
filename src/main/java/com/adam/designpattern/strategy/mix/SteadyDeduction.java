package com.adam.designpattern.strategy.mix;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 00:36
 **/
public class SteadyDeduction implements IDeduction {
    @Override
    public boolean  exec(Card card, Trade trade){
        System.out.println("This is steady deduction.");
        return true;
    }

}
