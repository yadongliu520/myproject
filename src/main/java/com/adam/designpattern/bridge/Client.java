package com.adam.designpattern.bridge;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 07:56
 **/
public class Client {
    public static void main(String[] args) {
        House house=new House();
        System.out.println("HouseCorp operation");
        HouseCorp houseCorp=new HouseCorp(house);
        houseCorp.makeMoney();
        System.out.println("\n");
        System.out.println("ShanzhaiCorp operation");
        ShanZhaiCorp shanZhaiCorp=new ShanZhaiCorp(new IPod());
        shanZhaiCorp.makeMoney();
    }
}
