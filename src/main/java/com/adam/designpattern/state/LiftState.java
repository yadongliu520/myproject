package com.adam.designpattern.state;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 15:36
 **/
public abstract class LiftState {
    protected Context ctx;
// 这也是一种不错方式，单例实例化一次对象
//    private volatile  static Context ctx=null;
//    public static Context getCtx(){
//        if(ctx ==null){
//            synchronized(Context.class){
//               if(ctx==null)  ctx=new Context();
//            }
//        }
//        return ctx;
//    }

    public void setContext(Context ctx){
        this.ctx=ctx;
    }

    protected abstract void close();
    protected abstract void open();
    protected abstract void run();
    protected abstract void stop();

}
