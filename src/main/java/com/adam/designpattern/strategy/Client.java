package com.adam.designpattern.strategy;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-08 23:48
 **/
public class Client {
    public static void main(String[] args) {
        Calculator1 cal1=new Calculator1();
        System.out.println(cal1.exec(1,2, "+"));

        Context ctx =new Context();
        Add add=new Add();
        Sub sub=new Sub();
        ctx.set(add);
        System.out.println(ctx.exec(1,2));
        ctx.set(sub);
        System.out.println(ctx.exec(3,2));

        System.out.println(CalculatorEnum.ADD.exec(1,3));
        System.out.println(CalculatorEnum.ADD.exec2(1,3));

        System.out.println(CalculatorEnum.ADD.getValue());
    }
}
