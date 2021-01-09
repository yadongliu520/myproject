package com.adam.designpattern.state;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 15:48
 **/
public class Client {
    public static void main(String[] args) {
        Context ctx=new Context();
        LiftState state=ctx.RUNNING_STATE;
        ctx.setLiftState(state);
        ctx.open();
        ctx.close();
        ctx.run();
        ctx.stop();
    }
}
