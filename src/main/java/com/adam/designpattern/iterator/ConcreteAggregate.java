package com.adam.designpattern.iterator;

import java.util.Iterator;
import java.util.Vector;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-25 23:51
 **/
public class ConcreteAggregate implements Aggregate {
    private Vector<String> vector;
    @Override
    public void add(String e) {
        this.vector.add(e);
    }

    @Override
    public String get(int index) {
        return vector.get(index);
    }

    @Override
    public Iterator<String> iterator() {
        return new ConcreteIterator(this.vector);
        //return this.vector.iterator();
    }
}
