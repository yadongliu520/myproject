package com.adam.designpattern.strategy.mix;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 00:40
 **/
public class DeductionContext {
    private IDeduction deduction;
    public DeductionContext(IDeduction deduction){
        this.deduction=deduction;
    }

    public boolean exec(Card card, Trade trade){
        return  deduction.exec(card,trade);
    }

}
