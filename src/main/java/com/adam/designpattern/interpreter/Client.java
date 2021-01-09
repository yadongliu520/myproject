package com.adam.designpattern.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-02 16:41
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        String expStr=getExpStr();
        HashMap<String,Integer> var=getValue(expStr);
        Calcultor cal=new Calcultor(expStr);
        System.out.println("Result: " + expStr+"="+cal.run(var));
    }

    public static String getExpStr() throws IOException{
        System.out.println("Input expression:");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    public static HashMap<String, Integer> getValue(String exprStr) throws IOException{
        HashMap<String,Integer> map=new HashMap<>();
        for(char ch:exprStr.toCharArray()){
            if(ch !='+' && ch!='-'){
                if(!map.containsKey(String.valueOf(ch))){
                    System.out.println("Input value of " + ch);
                    String in=(new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }
        return map;
    }

}
