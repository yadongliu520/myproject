package com.adam.designpattern.factory.absfactory;

import com.adam.designpattern.factory.BlackHuman;
import com.adam.designpattern.factory.IHuman;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-19 08:42
 **/
public class FemalFactory implements IFactory {

    @Override
    public AbstractBlackHuman blackHumanFactory() {
        return new FemalBlackHuman();
    }

    @Override
    public IHuman blackHumanFactory2() {
        return new FemalBlackHuman2();
    }

    @Override
    public IHuman blackHumanFactory3() {
        return new FemalBlackHuman3();
    }

    @Override
    public AbstractBlackHuman whiteHumanFactory() {
        return null ;
    }

    @Override
    public AbstractBlackHuman yellowHumanFactory() {
        return null;
    }
}
