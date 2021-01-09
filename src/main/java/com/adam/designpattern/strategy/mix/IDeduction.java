package com.adam.designpattern.strategy.mix;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 00:36
 **/
public interface IDeduction {
    boolean exec(Card card, Trade trade);
}
