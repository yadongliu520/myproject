package com.adam.basic.usefinal;

/**
 * @Description: Final修饰类.可以修改类的成员值，类本身对象不变
 * @Author: Adam
 * @Date: 2021-11-03 08:47
 **/
public class FinalClass {
    static class User{
        String name="zhang";
        int age;
        public String toString(){
            return "Name: " + name + " Age: " + age;
        }
    }
    public static void main(String[] args) {
        final User user = new User();
        user.age=11;
        System.out.println(user.hashCode());
        user.age=12;
        System.out.println(user.hashCode());

    }
}
