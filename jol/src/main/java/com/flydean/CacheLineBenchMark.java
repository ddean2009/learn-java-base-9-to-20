package com.flydean;

import org.openjdk.jmh.annotations.*;
//import sun.misc.Contended;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version CacheLineBenchMark,  2020/6/19 9:04 上午
 */

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1, jvmArgsPrepend = "-XX:-RestrictContended")
@Warmup(iterations = 10)
@Measurement(iterations = 25)
@Threads(2)
public class CacheLineBenchMark {

    private CacheLine cacheLine= new CacheLine();
    private CacheLinePadded cacheLinePadded = new CacheLinePadded();

    @Group("unpadded")
    @GroupThreads(1)
    @Benchmark
    public long updateUnpaddedA() {
        return cacheLine.a++;
    }

    @Group("unpadded")
    @GroupThreads(1)
    @Benchmark
    public long updateUnpaddedB() {
        return cacheLine.b++;
    }

    @Group("padded")
    @GroupThreads(1)
    @Benchmark
    public long updatePaddedA() {
        return cacheLinePadded.a++;
    }

    @Group("padded")
    @GroupThreads(1)
    @Benchmark
    public long updatePaddedB() {
        return cacheLinePadded.b++;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(CacheLineBenchMark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}
