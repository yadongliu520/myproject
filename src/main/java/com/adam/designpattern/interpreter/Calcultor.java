package com.adam.designpattern.interpreter;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-02 16:22
 **/
public class Calcultor {
    private Expression expression;
    public Calcultor(String expStr){
        Stack<Expression> stack=new Stack<>();
        char[] charArray=expStr.toCharArray();

        Expression left=null;
        Expression right=null;

        for(int i=0;i<charArray.length;i++){
            switch (charArray[i]){
                case '+':
                    left=stack.pop();
                    right=new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left,right));
                    break;
                case '-':
                    left=stack.pop();
                    right=new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left,right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));

            }
        }
        this.expression=stack.pop();

    }
    public int run(HashMap<String,Integer> var){
        return this.expression.interpreter(var);
    }
}
