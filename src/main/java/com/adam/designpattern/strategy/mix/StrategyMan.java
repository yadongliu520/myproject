package com.adam.designpattern.strategy.mix;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 00:43
 **/
public enum StrategyMan {
    SteadyDeduction("com.adam.designpattern.strategy.mix.SteadyDeduction"),
    FreeDeduction("com.adam.designpattern.strategy.mix.FreeDeduction");
    String value="";
    StrategyMan(String value){
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }
}
