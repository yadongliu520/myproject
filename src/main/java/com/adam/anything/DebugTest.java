package com.adam.anything;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-11-21 07:50
 **/
public class DebugTest {
    Integer num;
    String str;
    public int value(){
        num=num+1;
        return num;
    }

    public String strValue(){
        str = str + "1";
        return str;
    }
    public static void conditionDebug(){
        for(int i=0;i<100;i++){
            System.out.println(i);//通过断点出右键设置条件如i==10,满足条件时触发断点停留
        }
    }
    public static void mmultiThreadDubug(){
        new Thread(()->{
            System.out.println("Thread-1");
        }, "Thread-1").start();

        new Thread(()->{
            System.out.println("Thread-2");
        }, "Thread-2").start();

        System.out.println("Main");
    }
    public static void main(String[] args) {
        //mmultiThreadDubug();
        //conditionDebug();
        DebugTest test=new DebugTest();
        //System.out.println(test.value());//测试变量断点
        System.out.println(test.strValue());
    }
}
