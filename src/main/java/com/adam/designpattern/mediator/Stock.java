package com.adam.designpattern.mediator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-23 08:31
 **/
public class Stock extends AbstractColleage {
    private AtomicInteger stockNumber=new AtomicInteger(0);
    public Stock(AbstractMediator mediator) {
        super(mediator);
    }

    public void increaseStock(int number){
        System.out.println("Stock increased.");
        stockNumber.addAndGet(number);
        System.out.println("Current stock: "+stockNumber.get());
    }
    public void decreaseStock(int number){
        System.out.println("Stock decrease.");
        stockNumber.addAndGet(0-number);
        System.out.println("Current stock: "+stockNumber.get());
    }

    public AtomicInteger getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(AtomicInteger stockNumber) {
        this.stockNumber = stockNumber;
    }
}
