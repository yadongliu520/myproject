package com.adam.designpattern.state;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 15:42
 **/
public class OpenningState extends LiftState {
    @Override
    protected void close() {
//        LiftState.getCtx().setLiftState(LiftState.getCtx().CLOSING_STATE);
//        LiftState.getCtx().getLiftState().close();

        this.ctx.setLiftState(ctx.CLOSING_STATE);
        //this.ctx.getLiftState().close();
        this.ctx.close();
    }

    @Override
    protected void open() {
        System.out.println("Lift opened.");
    }

    @Override
    protected void run() {

    }

    @Override
    protected void stop() {

    }
}
