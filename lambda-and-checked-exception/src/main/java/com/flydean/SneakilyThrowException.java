package com.flydean;

import java.util.function.Function;

public class SneakilyThrowException {

    public static <T extends Exception,R> R sneakyThrow(Exception t) throws T {
        throw (T) t;
    }

    static <T, R> Function<T, R> unchecked(FunctionWithThrow<T, R> f) {
        return t -> {
            try {
                return f.apply(t);
            } catch (Exception ex) {
                return SneakilyThrowException.sneakyThrow(ex);
            }
        };
    }



}
