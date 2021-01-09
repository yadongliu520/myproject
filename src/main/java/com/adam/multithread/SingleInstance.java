package com.adam.multithread;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-07-27 23:47
 **/
public class SingleInstance {
    private  static SingleInstance instance;
    private  volatile static SingleInstance instance2;
    private   static  final SingleInstance instance3 = new SingleInstance();
    private SingleInstance(){}
    public static Object getInstance6(){
        return SingleInstance.instance3;
    }
    public synchronized static SingleInstance getInstance(){
        if(instance == null)
            instance=new SingleInstance();
        return  instance;
    }

    public static SingleInstance getInstance2(){
        if(instance2 == null){
          synchronized(SingleInstance.class){//双重检查锁定
              if(instance2 == null) instance2=new SingleInstance();
          }
        }
        return instance2;
    }

    private static class InstanceHolder{
        public static   SingleInstance o = new SingleInstance();
    }

    private static class InstanceHolder1{
        private static SingleInstance o = new SingleInstance();
    }
    public static SingleInstance getInstance5(){
        return InstanceHolder1.o;
    }

    public static SingleInstance getInstance3(){
        return InstanceHolder.o;
    }

    private volatile static SingleInstance instance4;

    public static SingleInstance getInstance4(){
        if(instance4 == null){
            synchronized(SingleInstance.class){
                if(instance4 == null)
                    instance4 =new SingleInstance();
            }
        }
        return instance4;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        System.out.println(SingleInstance.getInstance());
        //通过反射构建出对像
        SingleInstance singleton = SingleInstance.getInstance();
        Constructor<SingleInstance> constructor = SingleInstance.class.getDeclaredConstructor();//可以反射私有方法，getConstructor()不能反射私有方法
        constructor.setAccessible(true);
        SingleInstance newSingleton = constructor.newInstance();
        System.out.println(singleton == newSingleton);
    }
}
