package com.adam.designpattern.strategy;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-09 00:06
 **/
public enum CalculatorEnum {
    ADD("+"){
       public int exec(int a,int b){
           return a+b;
       }
       public int exec2(int a, int b){
           return a+b;
       }
    },

    SUB("-"){
        public int exec(int a, int b){
            return a-b;
        }

        public int exec2(int a, int b) {
            return a-b;
        }
    };

    private String value="";
    private  CalculatorEnum(String value) {
        this.value=value;
    }

    public String getValue(){
        return this.value;
    }

    public abstract int exec(int a, int b);
    public abstract int exec2(int a, int b);
}
