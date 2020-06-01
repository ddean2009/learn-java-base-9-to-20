package com.flydean;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version PrintCompilationUsage,  2020/5/29 9:07 上午
 */
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1,
        jvmArgsPrepend = {"-XX:+UnlockDiagnosticVMOptions",
                "-Xbatch",
                "-XX:-TieredCompilation",
                "-XX:+PrintCompilation"
}
)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class PrintCompilationUsage {

    int x;
    @Benchmark
    public void testPrintCompilation() {
        for (int c = 0; c < 1000; c++) {
            synchronized (this) {
                x += 0xFF;
            }
        }
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(PrintCompilationUsage.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
