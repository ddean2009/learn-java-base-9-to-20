package com.flydean;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version TLABUsage,  2020/5/29 9:07 上午
 */
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 3,
        jvmArgsPrepend = {
                "-XX:+UnlockExperimentalVMOptions",
                "-XX:+PrintTLAB",
//                "-XX:+UseEpsilonGC",
//                "-XX:EpsilonMaxTLABSize=4M"
}
)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class TLABUsage {

    @Benchmark
    public void testTLABUsage() {
        Object[] objects = new Object[100000];
        for (int i = 0; i < 10000; i++) {
            objects[i] = new Object();
        }
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TLABUsage.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
