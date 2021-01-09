package com.adam.designpattern.mediator;

import java.util.Random;

/**
 * @Description: Mediator
 * @Author: Adam
 * @Date: 2020-09-23 08:36
 **/
public class Mediate extends AbstractMediator {
    @Override
    public void execute(String str, Object...objects) {
        if(str.equals("buy")){
            this.buy((Integer)objects[0]);
        }else if(str.equals("refuseBuy")){
            this.refuseBuy();
        }else if(str.equals("cleanStock")){
            this.cleanStock();
        }else  if(str.equals("sell")){
            this.sell((Integer)objects[0]);
        }
    }
    public void buy(int num){

        System.out.println("Buy: " + num);
        super.stock.increaseStock(num);

    }

    public void refuseBuy(){
        int stockNum=super.stock.getStockNumber().get();
        if(stockNum<10){
            System.out.println("Stock is insufficient. refuse to buy.");
        }
    }

    public void sell(int num){
        System.out.println("Sell " + num);
        super.stock.decreaseStock(num);
    }

    public void cleanStock(){
        System.out.println("Clean stock.");
        int num=super.stock.getStockNumber().get();
        super.sale.offSale(num);
    }

}
