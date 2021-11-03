package com.adam.basic.usestatic;

/**
 * @Description: Static修饰变量，类的不同对象持有同一个副本，以下实例输出随机数，不同对象的每次j值相等。
 * 而final可以改变值，每次i不一样
 * 1、final可提高习性能
 * 2、多线程环境下可以共享，不需要额外同步开销
 * 3、final内存模型：编译器对变量读写在特定规则不重排序：
 * 构造函数内，对一个 final 变量的写入，与随后把这个被构造对象的引用赋值给一个变量，这两个操作之间不可重排序
 * 首次读一个包含 final 变量的对象，与随后首次读这个 final 变量，这两个操作之间不可以重排序
 * 参考链接：https://www.cnblogs.com/wupeixuan/p/11750053.html
 * @Author: Adam
 * @Date: 2021-11-03 20:05
 **/
public class StaticClass {
    static class MyClass {
        public final double i = Math.random();
        public static double j = Math.random();
    }

    public static void main(String[] args) {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);
    }


}
