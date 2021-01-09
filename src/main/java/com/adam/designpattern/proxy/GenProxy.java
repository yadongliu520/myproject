package com.adam.designpattern.proxy;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-21 17:11
 **/
public class GenProxy implements IGamePlayer {
    private IGamePlayer player;
    public GenProxy(String user){
        //this.player=new GamePlayer(this,user);
        this.player=new GamePlayer(user);
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
