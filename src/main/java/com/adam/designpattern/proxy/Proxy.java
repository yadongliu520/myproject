package com.adam.designpattern.proxy;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-21 15:01
 **/
public class Proxy implements IGamePlayer {
    private IGamePlayer player;
    public Proxy(IGamePlayer player){
        this.player=player;
    }
    @Override
    public void login() {
        this.player.login();
    }

    @Override
    public void killBoss() {
        this.player.killBoss();
    }

    @Override
    public void upgrade() {
        this.player.upgrade();
    }
}
