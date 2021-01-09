package com.adam.designpattern.interpreter;

import java.util.HashMap;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-02 16:21
 **/
public class SubExpression extends SymbolExpression {
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return this.left.interpreter(var)-this.right.interpreter(var);
    }
}
