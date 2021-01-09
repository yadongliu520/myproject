package com.adam.designpattern.interpreter;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-02 16:12
 **/
public abstract class SymbolExpression extends Expression {
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right){
        this.left=left;
        this.right=right;
    }
}
