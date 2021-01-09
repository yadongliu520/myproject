package com.adam.designpattern;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Description:加载类并打印其中的方法
 * @Author: Adam
 * @Date: 2020-08-03 21:53
 **/
public class ClassLoaderEx {
    public static void main(String[] args) throws Exception {
        String dirV1 = "file:///Users/adamliu/java_tmp/v1/";
        String dirV2 = "file:///Users/adamliu/java_tmp/v2/";
        URLClassLoader v1 = new URLClassLoader(new URL[]{new URL(dirV1)});
        URLClassLoader v2 = new URLClassLoader(new URL[]{new URL(dirV2)});

        Class<?> depV1Class = v1.loadClass("Dep");
        Object depv1 = depV1Class.getConstructor().newInstance();
        depV1Class.getMethod ("print").invoke(depv1);

        Class<?> depV2Class = v2.loadClass("Dep");
        Object depv2 = depV2Class.getConstructor().newInstance();
        depV2Class.getMethod("print").invoke(depv2);
        System.out.println(depV1Class.equals(depV2Class));

        URLClassLoader v3=new URLClassLoader(new URL[]{new URL("url")});
        Class<?> c=v3.loadClass("ClassName");
        Object o=c.getConstructor().newInstance();
        c.getMethod("fun").invoke(o);
        c.forName("");

    }
}
