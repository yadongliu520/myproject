package com.adam.designpattern.state;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 15:44
 **/
public class RunningState extends LiftState {
    @Override
    protected void close() {

    }

    @Override
    protected void open() {

    }

    @Override
    protected void run() {
        System.out.println("Lift is running.");
    }

    @Override
    protected void stop() {
//        LiftState.getCtx().setLiftState(LiftState.getCtx().STOPING_STATE);
//        LiftState.getCtx().getLiftState().close();

        this.ctx.setLiftState(ctx.STOPING_STATE);
        this.ctx.getLiftState().stop();

    }
}
