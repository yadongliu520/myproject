package com.adam.anything;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-31 10:12
 **/
public class Class1 {
    private static int  a;
    static{
        a=1;
    }
    Class1 c;
    public  Class2 class2;
    Class1(){}
    Class1(Class2 class2){this.class2=class2;}
    public Class2 newClass2(Class2 c){
        return c;
    }

    public void func(){
        System.out.println("HIHI Class1");
        System.out.println(a);//静态变量随构造函数初始化
    }

    public static void main(String[] args) {
        Class1 c1=new Class1();
        c1.func();
        Class1 c2=new Class1(){
            @Override
            public void func(){
                System.out.println("Override");
            }
        };
        //c2.func();//执行重载的函数


        Class1 c3=new Class1(new Class2(){
            @Override
            public void func(){
                System.out.println("HIHI Class2 override.");
            }
        });
        c3.func();
        c3.class2.func();//将输出重写的函数
    }

}
