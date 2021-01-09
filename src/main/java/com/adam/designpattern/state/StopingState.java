package com.adam.designpattern.state;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 15:45
 **/
public class StopingState extends LiftState {
    @Override
    protected void close() {

    }

    @Override
    protected void open() {
//        LiftState.getCtx().setLiftState(LiftState.getCtx().OPENNING_STATE);
//        LiftState.getCtx().getLiftState().open();

        this.ctx.setLiftState(ctx.OPENNING_STATE);
        this.ctx.getLiftState().open();

    }

    @Override
    protected void run() {

    }

    @Override
    protected void stop() {
        System.out.println("Lift stoped.");
    }
}
