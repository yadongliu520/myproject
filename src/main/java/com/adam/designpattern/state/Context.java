package com.adam.designpattern.state;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 15:36
 **/
public class Context {
    public static final OpenningState OPENNING_STATE=new OpenningState();
    public static final ClosingState CLOSING_STATE=new ClosingState();
    public static final RunningState RUNNING_STATE=new RunningState();
    public static final StopingState STOPING_STATE=new StopingState();

    public Context(){
        OPENNING_STATE.setContext(this);
        CLOSING_STATE.setContext(this);
        RUNNING_STATE.setContext(this);
        STOPING_STATE.setContext(this);
    }

    private LiftState liftState;
    public void setLiftState(LiftState liftState){
        this.liftState=liftState;
    }

    public LiftState getLiftState(){
        return liftState;
    }

    public void open(){
        this.liftState.open();
    }

    public void close(){
        this.liftState.close();
    }

    public void run(){
        this.liftState.run();
    }

    public void stop(){
        this.liftState.stop();
    }
}
