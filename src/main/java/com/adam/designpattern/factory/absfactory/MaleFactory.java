package com.adam.designpattern.factory.absfactory;

import com.adam.designpattern.factory.IHuman;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-19 08:42
 **/
public class MaleFactory implements IFactory {

    @Override
    public MaleBlackHuman blackHumanFactory() {
        return new MaleBlackHuman();
    }

    @Override
    public IHuman blackHumanFactory2() {
        return new MaleBlackHuman2();
    }

    @Override
    public IHuman blackHumanFactory3() {
        return new MaleBlackHuman3();
    }

    @Override
    public AbstractBlackHuman whiteHumanFactory() {
        return null;
    }

    @Override
    public AbstractBlackHuman yellowHumanFactory() {
        return null;
    }
}
