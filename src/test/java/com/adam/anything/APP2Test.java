package com.adam.anything;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class APP2Test {

    public static <T extends Comparable> T[] bubbleSort2(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i; j--) {
                if (arr[j].compareTo(arr[j - 1]) > 0) {
                    T tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
        return arr;
    }


    public static Boolean isOld2(String v1,String v2){
        String[] ver1=v1.split("\\.");
        String[] ver2=v2.split("\\.");
        for(int i=0;i<ver1.length||i<ver2.length;i++){
            int x=0,y=0;
            if(i<ver1.length){
                x=Integer.parseInt(ver1[i]);
            }
            if(i<ver2.length){
                y=Integer.parseInt(ver2[i]);
            }
            if(x>=y){
                return true;
            }
        }
        return false;
    }

    public static Boolean isOld(String v1,String v2){
        int i=0;
        int j=0;
        while(i<v1.length()||j<v2.length()){
            int num1=0;
            int num2=0;
            while(i<v1.length()&&v1.charAt(i)!='.'){
                num1=num1*10+v1.charAt(i++)-'0';
            }

            while(j<v2.length()&&v2.charAt(j)!='.'){
                num2=num2*10+v2.charAt(j++)-'0';
            }
            if(num1>num2) {
                return true;
            }else if(num2>num1){
                return false;
            }
            i++;
            j++;
        }
        return false;
    }


        public static  <T extends Comparable> T[] bubbleSort(T[] t){
            //this.t=t;
            for(int i=t.length-1;i>=0;i--){
                for(int j=i-1;j>=0;j--){
                    if(t[i].compareTo(t[j])>0){
                        T temp=t[i];
                        t[i]=t[j];
                        t[j]=temp;
                    }
                }
            }

            return t;
        }

    public static void assertTrue(boolean cond) {
        if (!cond) {
            throw new RuntimeException("false!");
        }
    }

    public static String getLevelByQuotaPolicy(Map<Integer,String> priorityNumber2Name,int cpuUsed,int quotaLimit,String originalLevel){
        Map<Integer,String> map=new HashMap<>();
        map.put(0,"C");
        map.put(1,"B");
        map.put(2,"A");
        map.put(3,"S");
        map.put(4,"SS");
        map.put(5,"SSS");

        Map<String,Integer> map1=new HashMap<>();
        map1.put("C",0);
        map1.put("B",1);
        map1.put("A",2);
        map1.put("S",3);
        map1.put("SS",4);
        map1.put("SSS",5);

        int num;
        if(cpuUsed<quotaLimit)return originalLevel;
        int over=cpuUsed-quotaLimit;
        if(over%quotaLimit/2==0)num=over/(quotaLimit/2);
        else num=over/(quotaLimit/2)+1;
        if(originalLevel=="C"&&num>=0)return originalLevel;
        int curLevel=map1.get(originalLevel)-num;
        if(curLevel<=0)return map.get(0);
        return map.get(curLevel);
    }

    @Test
    public  void test1(){
        assertTrue(isOld("1.2.1","1.0.1000").equals(true));
        assertTrue(isOld("1.0.1","1.1").equals(false));
        assertTrue(isOld("2.5","2.4.1").equals(true));
        assertTrue(isOld("5.4.3","5.4").equals(true));
    }
    @Test
    public  void test2(){
        String[] arr={"a","b","c","d"};
        Integer[] arr2={1,2,3,4};
        System.out.println(Arrays.toString(bubbleSort(arr)));
        assertTrue(Arrays.toString(bubbleSort(arr)).equals("[d, c, b, a]"));
        assertTrue(Arrays.toString(bubbleSort(arr2)).equals("[4, 3, 2, 1]"));
    }
    @Test
    public  void test3(){
        final HashMap<Integer, String> map = new HashMap<>();
        map.put(5, "C");
        map.put(10, "B");
        map.put(15, "A");
        map.put(17, "S");
        map.put(22, "SS");
        map.put(33, "SSS");
        map.put(35, "SSSS");
        assertTrue(getLevelByQuotaPolicy(map, 101, 100, "A").equals("B(10)"));
        assertTrue(getLevelByQuotaPolicy(map, 99, 100, "SSSS").equals("SSSS(35)"));
        assertTrue(getLevelByQuotaPolicy(map, 151, 100, "SSSS").equals("SS(22)"));
        assertTrue(getLevelByQuotaPolicy(map, 951, 100, "SSSS").equals("C(5)"));
    }

    @Test
    public void temp(){
        int num='1'-'2';
        System.out.println(num);
    }

}
