package com.flydean;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version CachelineUsage,  2020/5/26 8:08 下午
 */
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1,
        jvmArgsPrepend = {
//        "-XX:-UseBiasedLocking",
                "-XX:CompileCommand=print,com.flydean.CachelineUsage::test*"
}
        )
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class CachelineUsage {

    private static int[] array = new int[64 * 1024 * 1024];

    @Benchmark
    public void test1() {
        int length = array.length;
        for (int i = 0; i < length; i=i+1)
            array[i] ++;
    }
    @Benchmark
    public void test2() {
        int length = array.length;
        for (int i = 0; i < length; i=i+2)
            array[i] ++;
    }
//    @Benchmark
//    public void test3() {
//        int length = array.length;
//        for (int i = 0; i < length; i=i+3)
//            array[i] ++;
//    }
//
//    @Benchmark
//    public void test4() {
//        int length = array.length;
//        for (int i = 0; i < length; i=i+4)
//            array[i] ++;
//    }
//
//    @Benchmark
//    public void test8() {
//        int length = array.length;
//        for (int i = 0; i < length; i=i+8)
//            array[i] ++;
//    }
//
//    @Benchmark
//    public void test16() {
//        int length = array.length;
//        for (int i = 0; i < length; i=i+16)
//            array[i] ++;
//    }
//
//    @Benchmark
//    public void test32() {
//        int length = array.length;
//        for (int i = 0; i < length; i=i+32)
//            array[i] ++;
//    }
//
//    @Benchmark
//    public void test64() {
//        int length = array.length;
//        for (int i = 0; i < length; i=i+64)
//            array[i] ++;
//    }
//
//    @Benchmark
//    public void test128() {
//        int length = array.length;
//        for (int i = 0; i < length; i=i+128)
//            array[i] ++;
//    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(CachelineUsage.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}
