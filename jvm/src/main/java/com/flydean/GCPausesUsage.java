package com.flydean;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version GCPausesUsage,  2020/6/14 1:03 下午
 */

@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1,
        jvmArgsPrepend = {
//        "-XX:+UseParallelOldGC",
                "-XX:+UnlockExperimentalVMOptions",
                "-XX:+UseEpsilonGC",
                "-Xlog:gc",
}
)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class GCPausesUsage {

    List<Object> list;
    @Benchmark
    public void testGCPause() {
        list = new ArrayList<>();
        for (int c = 0; c < 10_000_000; c++) {
            list.add(new Object());
        }
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(GCPausesUsage.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
