package com.flydean;

import com.sun.jna.Library;
import com.sun.jna.Native;

import java.nio.*;

import static org.junit.Assert.assertEquals;

public class BufferUsage {

    public  interface TestLibrary extends Library {

        int fillInt8Buffer(ByteBuffer buf, int len, byte value);
    }

    public static void main(String[] args) {
        TestLibrary lib = Native.load("testlib", TestLibrary.class);

        ByteBuffer buf  = ByteBuffer.allocate(1024).order(ByteOrder.nativeOrder());
        final byte MAGIC = (byte)0xED;
        lib.fillInt8Buffer(buf, 1024, MAGIC);
        for (int i=0;i < buf.capacity();i++) {
            assertEquals("Bad value at index " + i, MAGIC, buf.get(i));
        }
    }
}
