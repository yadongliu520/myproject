package com.adam.anything;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-31 10:12
 **/
public class Class2 {
    Class2 c;
    Class2(){}
    public Class1 newClass1(Class1 c){
        return c;
    }

    public void func(){
        System.out.println("HIHI Class2");
    }

    public static void func2(){
        try{
            System.out.println("Executed.");
        }finally {
            System.out.println("Finally");//最终执行
        }
    }

    public static void main(String[] args) {
        Class1 c1=new Class1();
        Class2 c2=new Class2();
        c1.newClass2(c2).func();
        c2.newClass1(c1).func();
        c2.newClass1(c1).newClass2(c2).func();

        func2();
    }

}
