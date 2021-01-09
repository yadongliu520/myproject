package com.adam.designpattern.iterator;

import java.util.Iterator;
import java.util.Vector;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-25 23:40
 **/
public class ConcreteIterator implements Iterator{
    private Vector<String> vector;
    public int cursor=0;
    public ConcreteIterator(Vector<String> vector){
        this.vector=vector;
    }
//    @Override
//    public Iterator<String> iterator() {
//        return this.vector.iterator();
//    }

    @Override
    public boolean hasNext() {
        if(this.vector.size()==this.cursor){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        Object result=null;
        if(this.hasNext()){
            result=this.vector.get(cursor++);
        }
        return result;
    }
}
