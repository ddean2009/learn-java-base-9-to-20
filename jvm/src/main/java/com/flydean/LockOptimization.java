package com.flydean;

import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.profile.LinuxPerfAsmProfiler;
import org.openjdk.jmh.profile.LinuxPerfProfiler;
import org.openjdk.jmh.profile.StackProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version LockOptimization,  2020/5/26 8:08 下午
 */
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1,
        jvmArgsPrepend = {"-XX:-UseBiasedLocking",
                "-XX:+UnlockDiagnosticVMOptions",
                "-XX:CompileCommand=print,com.flydean.LockOptimization::test"
//                "-XX:+PrintAssembly"
}
        )
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class LockOptimization {

    int x;
    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public void test() {
        for (int c = 0; c < 1000; c++) {
            synchronized (this) {
                x += 0x42;
            }
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LockOptimization.class.getSimpleName())
//                .include(LockOptimization.class.getSimpleName()+".*measureAll*")
                // 预热5轮
//                .warmupIterations(3)
                // 度量10轮
//                .measurementIterations(5)
//                .forks(1)
//                .addProfiler(StackProfiler.class)
//                .addProfiler(LinuxPerfAsmProfiler.class,"mergeMargin=1000")
                .build();

        new Runner(opt).run();
    }
}
