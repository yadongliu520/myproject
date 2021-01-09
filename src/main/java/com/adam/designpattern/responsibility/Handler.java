package com.adam.designpattern.responsibility;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-11 22:54
 **/
public abstract class Handler {
    public final static int FATHER_LEVEL_REQUEST=1;
    public final static int HUSBAND_LEVEL_REQUEST=2;
    public final static int SON_LEVEL_REQUEST=3;
    private int type;
    private Handler nextHandler;
    public Handler(int type){
        this.type=type;
    }

    public final void handleMsg(IWoman woman){
        if(woman.getType()== this.type){
            this.reponse(woman);
        }else if(this.nextHandler !=null) {
            this.nextHandler.handleMsg(woman);
        }else {
            System.out.println("--No.");
        }
    }

    public  void setNextHandler(Handler handler){
        this.nextHandler=handler;
    }

    protected abstract void reponse(IWoman woman);
}
