package com.flydean;

@FunctionalInterface
public interface FunctionWithThrow<T, R> {
    R apply(T t) throws Exception;
}
