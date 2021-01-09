package com.adam.designpattern.interpreter;

import java.util.HashMap;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-02 15:52
 **/
public abstract class Expression {
    public abstract int interpreter(HashMap<String, Integer> var );
}
