package com.adam;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        final int i=0;
        assertTrue( true );
    }
    @Test
    public void testIterator(){

        ArrayList<Integer> arr =new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        Iterator<Integer> it=arr.iterator();
        while(it.hasNext()){
            Integer i=it.next();
            System.out.println("==1、" + i.intValue());

        }//迭代器循环完后，不能通过迭代器重放
        it.remove();//移除最后返回的元素
        System.out.println(it.hasNext());
        System.out.println(arr.size());
        Iterator<Integer> it2=arr.iterator();

    }
    @Test
    public void arrRandom() throws InterruptedException {
        int[] a={1,2};
        double d=3.09093;
        System.out.println((int)d);
        while (true){
            double r=Math.random()*3;
            System.out.println(Math.random()*3+" "+(int)r);
            //System.out.println((int)Math.floor(r)+" "+r +" " +(int)r);
            Thread.sleep(1000);
        }

    }

    @Test
    public void testIsPowerOfTwo(){
        int val=4;
        boolean isPowerOfTwo=((val & -val) == val);
        assertTrue("ok", isPowerOfTwo);
        System.out.println(isPowerOfTwo);
    }

    @Test
    public void testRandom(){
        Random random=new Random();
        final int a=random.nextInt(1);
        assertTrue("Random is not in (0,1)",(a==1|a==0));
        System.out.println((a==1|a==0));
    }
}
