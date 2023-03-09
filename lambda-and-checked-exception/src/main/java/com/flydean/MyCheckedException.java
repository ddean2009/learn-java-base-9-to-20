package com.flydean;

public class MyCheckedException extends Exception{
    @java.io.Serial
    private static final long serialVersionUID = -1574710658998033284L;

    public MyCheckedException() {
        super();
    }

    public MyCheckedException(String s) {
        super(s);
    }
}
