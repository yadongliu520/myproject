package com.adam.benchmark;
//import io.netty.microbench.util.AbstractMicrobenchmark;
import io.netty.util.concurrent.FastThreadLocal;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-26 19:48
 **/
@Threads(4)
@Measurement(iterations = 1, batchSize = 100)
public class FastThreadLocalFastPathBenchmark {
    private static final Random rand = new Random();

    @SuppressWarnings("unchecked")
    private static final ThreadLocal<Integer>[] jdkThreadLocals = new ThreadLocal[128];
    @SuppressWarnings("unchecked")
    private static final FastThreadLocal<Integer>[] fastThreadLocals = new FastThreadLocal[jdkThreadLocals.length];

    static {
        for (int i = 0; i < jdkThreadLocals.length; i ++) {
            final int num = rand.nextInt();
            jdkThreadLocals[i] = new ThreadLocal<Integer>() {
                @Override
                protected Integer initialValue() {
                    return num;
                }
            };
            fastThreadLocals[i] = new FastThreadLocal<Integer>() {
                @Override
                protected Integer initialValue() {
                    return num;
                }
            };
        }
    }

    @Benchmark
    public void jdkThreadLocalGet(Blackhole bh) {
        for (ThreadLocal<Integer> i: jdkThreadLocals) {
            bh.consume(i.get());
        }
    }

    @Benchmark
    public void fastThreadLocal(Blackhole bh) {
        for (FastThreadLocal<Integer> i: fastThreadLocals) {
            bh.consume(i.get());
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options= new OptionsBuilder().include(FastThreadLocalFastPathBenchmark.class.getSimpleName())
                .build();
        new Runner(options).run();

    }
}
