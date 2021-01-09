package com.adam.multithread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-08 19:32
 **/
public class ForkJoinEx {
    private static class Caculator extends RecursiveTask {
        final long THRESHOLD =3;
        long start;long end;
        public Caculator(long start, long end){
            this.start=start;
            this.end=end;
        }
        @Override
        protected Object compute() {
           boolean canCompute=end-start<=3?true:false;
           long result=0;
            if(canCompute){
                for(long i=start;i<=end;i++){
                    result +=i;
                }
                return result;
            }else{
                long mid=(start+end)/2;
                RecursiveTask leftTask=new Caculator(start, mid);
                RecursiveTask rightTask=new Caculator(mid+1,end);
                leftTask.fork();
                rightTask.fork();
                long leftResult=(long)leftTask.join();
                long rightResult=(long)rightTask.join();
                return leftResult+rightResult;
            }
        }

    public static void main(String[] args) throws Exception {
        ForkJoinPool fkp =new ForkJoinPool();
        long start=1,end=4;
        RecursiveTask compute = new Caculator(start,end);
        Future r= fkp.submit(compute);
        System.out.println("The result: " + (long)r.get());

        ForkJoinPool fkp2=new ForkJoinPool();
        RecursiveTask rt=new Caculator(1,5);
        Future restut2 = fkp2.submit(rt);
        System.out.println(restut2.get());
        }
    }
}
