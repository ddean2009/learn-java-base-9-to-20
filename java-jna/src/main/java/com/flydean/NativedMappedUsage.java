
package com.flydean;

import com.sun.jna.*;


public class NativedMappedUsage {

    public interface EnumerationTestLibrary extends Library {
        TestEnum returnInt32Argument(TestEnum arg);
    }

    public enum TestEnum implements NativeMapped {
        VALUE1, VALUE2;

        @Override
        public Object fromNative(Object nativeValue, FromNativeContext context) {
            return values()[(Integer) nativeValue];
        }

        @Override
        public Object toNative() {
            return ordinal();
        }

        @Override
        public Class<?> nativeType() {
            return Integer.class;
        }
    }


    public static void main(String[] args) {
        EnumerationTestLibrary lib = Native.load("testlib", EnumerationTestLibrary.class);
        assert TestEnum.VALUE1 == lib.returnInt32Argument(TestEnum.VALUE1);
        assert TestEnum.VALUE2 == lib.returnInt32Argument(TestEnum.VALUE2);
    }

}
