package com.adam.designpattern.proxy;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-21 15:06
 **/
public class Client {
    public static void main(String[] args) {
        IGamePlayer gamePlayer=new GamePlayer("San.");
        IGamePlayer proxy=new Proxy(gamePlayer);
        proxy.login();
        proxy.killBoss();
        proxy.upgrade();

        IGamePlayer genProxy=new GenProxy("San.");
        genProxy.login();
        genProxy.killBoss();
        genProxy.upgrade();

        IGamePlayer gamePlayer1=new GamePlayer("San.");
        IGamePlayer mustProxy= ((GamePlayer)gamePlayer1).getProxy();
        mustProxy.login();
        mustProxy.killBoss();
        mustProxy.upgrade();
    }


}
