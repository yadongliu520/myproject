package com.adam.netty;

import com.adam.multithread.ThreadState;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-26 15:05
 **/
public class FastThreadLocalEx {
    public static class FastThreadLocalTest {
        private static FastThreadLocal<Integer> fastThreadLocal = new FastThreadLocal<>();
        private static FastThreadLocal<Integer> fastThreadLocal2 = new FastThreadLocal<>();

        public static void main(String[] args) {
            fastThreadLocal2.set(11);
            ThreadState.SleepUtils.second(1);
            System.out.println(fastThreadLocal2.get());
            //if (thread instanceof FastThreadLocalThread) 使用FastThreadLocalThread更优，普通线程也可以
            new FastThreadLocalThread(() -> {
                for (int i = 0; i < 3; i++) {
                    fastThreadLocal.set(i);
                    System.out.println(Thread.currentThread().getName() + "====" + fastThreadLocal.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "fastThreadLocal1").start();


            new FastThreadLocalThread(() -> {
                for (int i = 0; i < 3; i++) {
                    fastThreadLocal.set(22);
                    System.out.println(Thread.currentThread().getName() + "====" + fastThreadLocal.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "fastThreadLocal2").start();
        }
    }

}
