package com.adam.designpattern.factory.absfactory;


import com.adam.designpattern.factory.IHuman;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-19 08:45
 **/
public class Client {
    public static void main(String[] args) {
        IFactory femalFactory=new FemalFactory();
        IFactory maleFactory=new MaleFactory();
        AbstractBlackHuman fBlackHuman=femalFactory.blackHumanFactory();
        AbstractBlackHuman mBackHuman=maleFactory.blackHumanFactory();

        fBlackHuman.getSex();
        mBackHuman.getSex();

        FemalBlackHuman2 fBlcakHuman2=(FemalBlackHuman2)femalFactory.blackHumanFactory2();
        MaleBlackHuman2 mBlcakHuman2=(MaleBlackHuman2) maleFactory.blackHumanFactory2();

        fBlcakHuman2.getSex();
        mBlcakHuman2.getSex();

        IHuman fBlcakHuman3 =femalFactory.blackHumanFactory3();
        IHuman mBlcakHuman3 = maleFactory.blackHumanFactory3();
        fBlcakHuman3.getSex();
        mBlcakHuman3.getSex();

    }
}
