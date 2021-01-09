package com.adam.designpattern.mediator;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-23 08:37
 **/
public class Client {
    public static void main(String[] args) {
        AbstractMediator mediator=new Mediate();


//        Sale sale=new Sale(mediator);
//        sale.sell(30);
        Stock stock=new Stock(mediator);
        mediator.setStock(stock);
        Stock stock2=mediator.getStock();

        mediator.execute("buy", 60);
        mediator.execute("sell", 30);

        System.out.println("Current stock: " + stock2.getStockNumber().get());


    }


}
