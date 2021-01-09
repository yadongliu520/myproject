package com.adam.designpattern.proxy;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-21 17:57
 **/
public class MustProxy implements IGamePlayer {
    private IGamePlayer player;
    public MustProxy(IGamePlayer player){
        this.player=player;
    }

    @Override
    public void login() {
        System.out.println("login.");
    }

    @Override
    public void killBoss() {
        System.out.println("killBoss.");
    }

    @Override
    public void upgrade() {
        System.out.println("upgrade.");
    }
}
