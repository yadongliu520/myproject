package com.adam.designpattern.strategy.mix;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 11:11
 **/
public class DeductionFacade {
    public void deduction() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Card card=new Card();
        Trade trade=new Trade();
        IDeduction iDeduction=StrategyFactory.getDeduction(StrategyMan.FreeDeduction);
        IDeduction iDeduction2=StrategyFactory.getDeduction();
        DeductionContext ctx=new DeductionContext(iDeduction2);
        ctx.exec(card, trade);
    }
}
