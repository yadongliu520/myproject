package com.adam.designpattern.proxy;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-21 15:00
 **/
public class GamePlayer implements IGamePlayer {
    private String user;
    private IGamePlayer proxy;
    public  GamePlayer(String user){
        this.user=user;
    }
    public GamePlayer(IGamePlayer proxy, String user){
        this.proxy=proxy;
        this.user=user;
    }

    public IGamePlayer getProxy(){
        if(this.proxy==null){
            this.proxy=new MustProxy(this);
        }
         return this.proxy;
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
