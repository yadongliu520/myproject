package com.adam.designpattern;

import com.adam.anything.ObjectWait;
import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-03 14:47
 **/
public class DynamicProxyEx {
    public interface Sell{
        void sell(String good);
    }
    public static class Vendor implements Sell{
        @Override
        public void sell(String good) {
            System.out.println("Sell Something");
        }
    }

    public static class DynamicProxy implements InvocationHandler {
        private Object obj;
        public DynamicProxy(Object obj){
            this.obj=obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before");
            //Object res = method.invoke(obj,args);
            if(method.getName().equalsIgnoreCase("sell")){
                method.invoke(obj,args);
               // System.out.println(args[0]);
                System.out.println("Executed in proxy");
            }
            System.out.println("after");
            return null;
        }
    }

    public static void main(String[] args){
        Sell subject=new Vendor();
        DynamicProxy inner = new DynamicProxy(subject);
        //Sell sell = (Sell)(Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[]{Sell.class}, inner));
        //Sell sell = (Sell)(Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), inner));
        Sell sell = (Sell)(Proxy.newProxyInstance(Vendor.class.getClassLoader(), Vendor.class.getInterfaces(), inner));
        sell.sell("good");
    }
}
