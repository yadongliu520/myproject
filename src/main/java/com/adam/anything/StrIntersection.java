package com.adam.anything;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2021-08-08 08:37
 **/
public class StrIntersection {
    public static String checkCommom(Integer a, Integer b) {
        String str1=Integer.toString(a);
        String str2=Integer.toString(b);
        HashSet<String> result = new HashSet<String>();
        int length1 = str1.length();
        int length2 = str2.length();
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                String char1 = str1.charAt(i) + "";
                String char2 = str2.charAt(j) + "";
                if (char1.equals(char2))
                {
                    result.add(char1);
                }
            }
        }

        Iterator<String> it = result.iterator();
        String str="";
        while (it.hasNext()) {
            String value = it.next();
            str=str+value;
            //System.out.println(value);
        }
        return str;
    }

    public static ArrayList<String> intersection(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
       ArrayList<String> result=new ArrayList<>();
        for(Integer e: arr1) {
            String str="";
            for(Integer e2: arr2) {
                str = str+ checkCommom(e, e2) + ",";
            }
        result.add(str);
       }
    return result;
    }

    public static void main(String[] args) {
        System.out.println(checkCommom(123, 124));
        ArrayList<Integer> arr1= new ArrayList<>();
        arr1.addAll(Arrays.asList(134568,3456789,24678,23789,12489,24679,45679,2345678,124567));
        ArrayList<Integer> arr2= new ArrayList<>();
        arr2.addAll(Arrays.asList(1456789,2489,234689,45789,1234567,23678,124567,3467,2456789));
        ArrayList<String> result=intersection(arr1,arr2);
        for(String str: result)
        System.out.println(str);
    }
}
