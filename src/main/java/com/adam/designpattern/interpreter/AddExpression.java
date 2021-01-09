package com.adam.designpattern.interpreter;

import java.util.HashMap;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-02 16:19
 **/
public class AddExpression extends SymbolExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
