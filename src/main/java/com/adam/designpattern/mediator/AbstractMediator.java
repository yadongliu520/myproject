package com.adam.designpattern.mediator;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-23 08:18
 **/
public abstract class AbstractMediator {
    protected Purchase purchase;
    protected Sale sale;
    protected Stock stock;

    public AbstractMediator(){
        purchase=new Purchase(this);
        sale=new Sale(this);
        stock=new Stock(this);
    }
    public abstract void execute(String str, Object...objects);

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
