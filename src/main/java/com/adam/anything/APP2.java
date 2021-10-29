package com.adam.anything;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2021-08-19 18:07
 * 2022笔试测试
 **/
public class APP2 {
    public static <T extends Comparable<T>> void insertionSort(T[] arr, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                T temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    public static void loop(){
        for(int i=0;i<2; i++){
            int j=0;
            for(j=0;j<2; j++){
                if (j==0) continue;
                System.out.println("j:" + j);
            }
            System.out.println("i: "+ i + "; j: " +j);
        }
    }

    public static <T extends Comparable<T>>void insertSort(T arr[]){
        //if(arr.length==1) return;
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0 && arr[j].compareTo(arr[j-1])>0;j--){
                T temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
            }
        }
    }

    public static int maximumGiftValue(int[][] grip){
        int n=grip.length;
        if(n==0) return 0;
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 &&j==0) dp[i][j]=grip[i][j];
                else if(i==0) dp[i][j]=dp[i][j-1]+grip[i][j];
                else if(j==0) dp[i][j]=dp[i-1][j]+grip[i][j];
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])+grip[i][j];
                }
            }

        }
        return dp[n-1][n-1];
    }

    public static int maxValue(int[][] grid){
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n;j++){
                if(i==0 && j ==0) continue;
                if(i==0) grid[i][j] += grid[i][j-1];
                else if(j==0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += Math.max(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }

    public static String convertString(String original){
        String [] res=  original.split(" ");
        for(int i=0;i<res.length;i++){
            res[i]=res[i].replace(" ","");
        }
        String realres=res[res.length-1];
        for(int i=res.length-2;i>0;i--){

            realres+=res[i]+" ";

        }
        realres+=res[0];
        return realres;

    }


    static  int[][] next = {{0,1},{1,0}};
    static boolean[][] marked;
    static int ans=0;

    public static int maximumGiftValue2(int[][] grid){
        int r = 0,c=0;//从左上角开始
        int row = grid.length,column=grid[0].length;
        marked = new boolean[row][column];
        dfs(grid,0,0,row,column,0);
        return ans;
    }
    static void dfs(int[][] path,int r,int c,int row,int column,int value){
        if(r>=row || c>= column || marked[r][c])return;
        value += path[r][c];
        if(r == row-1 && c == column -1) ans = Math.max(ans,value);// 等于右下角，找出最大值
        for(int[] i : next){
            marked[r][c]=true;
            dfs(path,r+i[0],c+i[1],row,column,value);
            marked[r][c]=false;
        }
    }

    public static String converString(String original){
        String[] strs = original.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=strs.length-2;i>=0;i--){
            sb.append(strs[i]);
            if(i != 0)sb.append(" ");
        }
        String s = sb.append(strs[strs.length-1]).toString();
        return s;
    }

    //动态规划
    public static int maximumGifValue(int[][] grid){

        int n = grid.length;
        int m = grid[0].length;
        //if(n==m && n==1 && m==1) return grid[0][0];
        int[][] dp = new int [n][m];
        dp[0][0] = grid[0][0];
        for(int i=1;i<n;i++)dp[i][0] = dp[i-1][0]+grid[i][0];
        for(int i=1;i<m;i++)dp[0][i] = dp[0][i-1]+grid[0][i];
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j] = grid[i][j]+Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n-1][m-1];
    }

    public static int maxValue3(int[][] grid){
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n;j++){
                if(i==0 && j ==0) continue;
                if(i==0) grid[i][j] += grid[i][j-1];
                else if(j==0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += Math.max(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }

    public static int maximumGiftValue3(int[][]grid){
        int n=grid.length;
        if(n==0) return 0;
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 &&j==0) dp[i][j]=grid[i][j];
                else if(i==0) dp[i][j]=dp[i][j-1]+grid[i][j];
                else if(j==0) dp[i][j]=dp[i-1][j]+grid[i][j];
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])+grid[i][j];
                }
            }

        }
        return dp[n-1][n-1];
    }
///===============

    public static <T extends Comparable> T[] bubbleSort(T[] arr) {
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


    public static String getLevelByQuotaPolicy(Map<Integer, String> priorityNumber2Name,
                                               int cpuUsed, int quotaLimit, String originalLevel) {
        int over = cpuUsed - quotaLimit;
        int newPriority = 0;
        for (Integer priority : priorityNumber2Name.keySet()) {
            if (priorityNumber2Name.get(priority).equals(originalLevel)) {
                newPriority = priority;
                break;
            }
        }
        if (over <= 0) {
            return originalLevel + "(" + newPriority + ")";
        }
        int level = (int) Math.ceil(over * 1.0 / (quotaLimit * 0.5));
        TreeMap<Integer, String> map = new TreeMap<>(priorityNumber2Name);
        for (int i = 0; i < level; i++) {
            if (map.lowerEntry(newPriority) == null) {
                return map.get(newPriority) + "(" + newPriority + ")";
            }
            newPriority = map.lowerKey(newPriority);
        }
        return map.get(newPriority) + "(" + newPriority + ")";
    }


//    public static Boolean isOld(String v1,String v2){
//        String[] v1s = v1.split("\\.");
//        String[] v2s = v2.split("\\.");
//        int minLen = Math.min(v1s.length,v2s.length);
//        for(int i=0;i<minLen;i++){
//            int num1 = Integer.parseInt(v1s[i]);
//            int num2 = Integer.parseInt(v2s[i]);
//            if(num1 > num2)
//                return true;
//            if(num1 < num2)
//                return false;
//        }
//        return v1s.length > v2s.length?true:false;
//    }



    static class Version implements Comparable<Version>{
        public int masterVersion;
        public int subVersion;
        public int editVersion;
        public Version(String s) {
            String[] versions=s.split("\\.");
            masterVersion=Integer.valueOf(versions[0]);
            if(versions.length>=2)
                subVersion=Integer.valueOf(versions[1]);
            if(versions.length==3)
                editVersion=Integer.valueOf(versions[2]);
        }
        @Override
        public int compareTo(Version o) {
            if(this.masterVersion!=o.masterVersion)
                return this.masterVersion-o.masterVersion;
            if(this.subVersion!=o.subVersion)
                return this.subVersion-o.subVersion;
            if(this.editVersion!=o.editVersion)
                return this.editVersion-o.editVersion;
            return 0;
        }

    }

    public static Boolean isOld(String s1,String s2) {
        Version v1=new Version(s1);
        Version v2=new Version(s2);
        if(s2.compareTo(s1)>=0) {
            return false;
        }
        else {
            return true;
        }
    }

    public static int calculateDownLevel(long used, long limit) {
        if (limit < 0 || used <= limit) {
            return 0;
        }
        double u = used;
        double l = limit;
        int down = (int) ((u - l) / l * 100 / 50) + 1;
        if (down < 0) {
            down = 0;
        }
        return down;
    }

    public static void assertTrue(boolean cond) {
        if (!cond) {
            throw new RuntimeException("false!");
        }
    }
public static void test1(){
    assertTrue(isOld("1.0.1","1.1").equals(false));
    assertTrue(isOld("2.5","2.4.1").equals(true));
    assertTrue(isOld("5.4.3","5.4").equals(true));
}

public static void test2(){
    String[] arr={"a","b","c","d"};
    Integer[] arr2={1,2,3,4};
    System.out.println(Arrays.toString(bubbleSort(arr)));
    assertTrue(Arrays.toString(bubbleSort(arr)).equals("[d, c, b, a]"));
    assertTrue(Arrays.toString(bubbleSort(arr2)).equals("[4, 3, 2, 1]"));
}
public static void test3(){
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

    public static void main(String[] args) throws Exception {
        test1();
        //test2();
        //test3();
    }
}
