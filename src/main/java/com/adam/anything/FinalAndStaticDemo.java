package com.adam.anything;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2021-06-19 15:52
 **/
public class FinalAndStaticDemo {
    public static void main(String[] args)  {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);
        FinalAndStaticDemo c1 = new FinalAndStaticDemo();
        c1.test(1);

        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));//true
        System.out.println((a == e));//false

        String a1 = "hello2";
        final String b1 = getHello();
        String c2 = b1 + 2;
        System.out.println((a1 == c2)); //false

    }

    public static String getHello() {
        return "hello";
    }

    static class MyClass {
        public final double i = Math.random();//每次都会改变
        public static double j = Math.random(); //每次不改变
    }

    public void test( int b) {
         int a = 10;
        new Thread(){
            public void run() {
                System.out.println(a);
                System.out.println(b);
            };
        }.start();
    }

}
