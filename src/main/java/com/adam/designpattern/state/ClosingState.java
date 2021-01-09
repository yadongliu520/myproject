package com.adam.designpattern.state;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 15:43
 **/
public class ClosingState extends LiftState {
    @Override
    protected void close() {
        System.out.println("Lift closed");
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
//        LiftState.getCtx().setLiftState(LiftState.getCtx().RUNNING_STATE);
//        LiftState.getCtx().getLiftState().run();

        this.ctx.setLiftState(ctx.RUNNING_STATE);
        this.ctx.getLiftState().run();
    }

    @Override
    protected void stop() {

//        LiftState.getCtx().setLiftState(LiftState.getCtx().STOPING_STATE);
//        LiftState.getCtx().getLiftState().stop();
        this.ctx.setLiftState(ctx.STOPING_STATE);
        this.ctx.getLiftState().stop();
    }
}
