package com.adam.designpattern.rule;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-04 09:39
 **/
public class Father {
    public Collection doSmt(HashMap map){
        System.out.println("Father did smt.");
        return map.values();
    }

    public Map doSmt2(Map map){
        System.out.println("Father di smt.");
        return map;
    }
}
