package com.adam.designpattern.objectpool;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Description: using common-pool instead of this  in practice
 * @Author: Adam
 * @Date: 2020-10-05 08:19
 **/
public abstract  class ObjectPool<T> {
    private Hashtable<T, ObjectStatus> pool = new Hashtable<>();

    public synchronized void checkIn(T t) {
        pool.get(t).setFree();//back to pool
    }

    public synchronized T checkOut() {
        T o=null;
        for (T t : pool.keySet()) {
            if (pool.get(t).validate()){
                pool.get(t).setUsing();
                o=t;
                break;
            }
        }
        return o;
    }
        class ObjectStatus {
            public void setUsing() {
            }

            public void setFree() {
            }

            public boolean validate() {
                return false;
            }
        }
        public abstract T create();
}
