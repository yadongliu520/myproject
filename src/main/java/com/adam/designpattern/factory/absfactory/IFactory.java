package com.adam.designpattern.factory.absfactory;

import com.adam.designpattern.factory.BlackHuman;
import com.adam.designpattern.factory.IHuman;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-19 08:39
 **/
public interface IFactory {
    AbstractBlackHuman blackHumanFactory();
    IHuman blackHumanFactory2();
    IHuman blackHumanFactory3();
    AbstractBlackHuman whiteHumanFactory();
    AbstractBlackHuman yellowHumanFactory();
}
