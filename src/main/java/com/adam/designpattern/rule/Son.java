package com.adam.designpattern.rule;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-04 09:42
 **/
public class Son extends Father {


    public Collection doSmt(HashMap map){
//        System.out.println("1Son did smt.");
//        return map.values();
        return  super.doSmt(map);
    }

    public Collection doSmt(Map map){
        System.out.println("2Son did smt.");
        return map.values();
    }

    @Override
    public HashMap doSmt2(Map map){
        System.out.println("Son did smt.");
        return (HashMap) map;
    }

    public static void main(String[] args) {
        Map map=new HashMap();
        HashMap map1=new HashMap();
        map.put("k1",1);
        Son son=new Son();
        Father father=new Son();
        Father father2=new Father();
        father2.doSmt(map1);
        father.doSmt(map1);
        son.doSmt(map);
        son.doSmt(map1);
        son.doSmt2(map);
        son.doSmt2(map1);
//        son.doSmt((HashMap) map);
//        son.doSmt(map);
//        son.doSmt(map1);
    }
}
