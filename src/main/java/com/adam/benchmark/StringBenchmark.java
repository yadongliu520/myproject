package com.adam.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-26 15:37
 **/
@BenchmarkMode({Mode.AverageTime, Mode.Throughput})
@Warmup(iterations = 1)
@Measurement(iterations = 1, time = 1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 1)
@Threads(1)
@State(Scope.Benchmark)
//@OperationsPerInvocation
public class StringBenchmark {
    @Param({ "10", "100"})
    private int n;

    @Setup
    public void setup() {
    }

    @TearDown
    public void tearDown() {
    }

//    static final String base="";
//
//    static String work(int x){
//        return base+x;
//    }

    @Benchmark
    public void testStringAdd(Blackhole blackhole) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += i;
        }
        blackhole.consume(s);
    }

    @Benchmark
    public void testStringBuilderAdd(Blackhole blackhole) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i);
        }
        blackhole.consume(sb.toString());
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringBenchmark.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
