package com.adam.anything;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-13 15:51
 **/
public class GenericType {
    public class Inner<T>{
        T a;
        public Inner(T a){
            this.a=a;
        }
        public T get(){
            return a;
        }
    }
    public <T extends Object> T get(T a){return a;};

    public static void main(String[] args) {
        GenericType mutiTpye=new GenericType();
        System.out.println(mutiTpye.get(1));
        System.out.println("The actual type is:" + mutiTpye.getClass().getName());
    }
}
