package com.adam.designpattern.strategy.mix;


import java.util.Random;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 00:50
 **/
public class StrategyFactory {
    public static  IDeduction getDeduction(StrategyMan strategy) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (IDeduction) Class.forName(strategy.getValue()).newInstance();
    }
    public static  IDeduction getDeduction() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (IDeduction) Class.forName(getStrategyType().getValue()).newInstance();
    }
    private static StrategyMan getStrategyType(){
        Random random=new Random();
        int flag=random.nextInt(2);
        if(flag==0)
            return StrategyMan.FreeDeduction;
        else
            return StrategyMan.SteadyDeduction;
    }
}
