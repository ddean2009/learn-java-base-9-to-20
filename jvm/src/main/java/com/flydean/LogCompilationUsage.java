package com.flydean;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version LogCompilationUsage,  2020/5/29 9:07 上午
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1
//        jvmArgsPrepend = {"-XX:+UnlockDiagnosticVMOptions",
//                "-XX:+LogCompilation",
//                "-XX:LogFile=/tmp/www.flydean.com.log"}
)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class LogCompilationUsage {

    int x;
    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public void testLogCompilation() {
        for (int c = 0; c < 1000; c++) {
            synchronized (this) {
                x += 0xFF;
            }
        }
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LockOptimization.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
