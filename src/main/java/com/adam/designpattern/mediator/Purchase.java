package com.adam.designpattern.mediator;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-23 08:22
 **/
public class Purchase extends AbstractColleage {

    public Purchase(AbstractMediator mediator) {
        super(mediator);
    }
    public void buy(int num){

        super.mediator.execute("buy " + num );
    }

    public void refuseBuy(){
        super.mediator.execute("refuseBuy");
    }
}
