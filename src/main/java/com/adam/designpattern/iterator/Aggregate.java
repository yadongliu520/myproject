package com.adam.designpattern.iterator;

import java.util.Iterator;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-25 23:47
 **/
public interface Aggregate {
     void add(String e);
     String get(int index);
     Iterator<String> iterator();
}
