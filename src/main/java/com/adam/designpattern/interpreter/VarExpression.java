package com.adam.designpattern.interpreter;

import java.util.HashMap;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-02 16:10
 **/
public class VarExpression extends Expression {
    private String key;
    public VarExpression(String key){
        this.key=key;
    }
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return  var.get(this.key);
    }
}
