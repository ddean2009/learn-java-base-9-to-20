package com.flydean;

import com.sun.jna.*;
import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class CallbackUsage {

    public static interface TestLibrary extends Library {

        interface VoidCallback extends Callback {
            void callback();
        }
        interface ByteCallback extends Callback {
            byte callback(byte arg, byte arg2);
        }

        void callVoidCallback(VoidCallback c);
        byte callInt8Callback(ByteCallback c, byte arg, byte arg2);
        void callVoidCallbackThreaded(VoidCallback c, int count, int ms, String name, int stacksize);

    }

    public static void main(String[] args) {
        TestLibrary lib = Native.load("testlib", TestLibrary.class);
        Pointer p = new Pointer("MultiplyMappedCallback".hashCode());
        Callback cbV1 = CallbackReference.getCallback(TestLibrary.VoidCallback.class, p);
        Callback cbB1 = CallbackReference.getCallback(TestLibrary.ByteCallback.class, p);
        log.info("cbV1:{}",cbV1);
        log.info("cbB1:{}",cbB1);

        final boolean[] voidCalled = { false };
        TestLibrary.VoidCallback cb1 = new TestLibrary.VoidCallback() {
            @Override
            public void callback() {
                voidCalled[0] = true;
            }
        };
        lib.callVoidCallback(cb1);
        assertTrue("Callback not called", voidCalled[0]);


        final boolean[] int8Called = {false};
        final byte[] cbArgs = { 0, 0 };
        TestLibrary.ByteCallback cb2 = new TestLibrary.ByteCallback() {
            @Override
            public byte callback(byte arg, byte arg2) {
                int8Called[0] = true;
                cbArgs[0] = arg;
                cbArgs[1] = arg2;
                return (byte)(arg + arg2);
            }
        };
        final byte MAGIC = 0x11;
        byte value = lib.callInt8Callback(cb2, MAGIC, (byte)(MAGIC*2));
        assertTrue("Callback not called", int8Called[0]);
        assertEquals("Wrong first callback argument",
                Integer.toHexString(MAGIC),
                Integer.toHexString(cbArgs[0]));
        assertEquals("Wrong second callback argument",
                Integer.toHexString(MAGIC*2),
                Integer.toHexString(cbArgs[1]));
        assertEquals("Wrong byte return",
                Integer.toHexString(MAGIC*3),
                Integer.toHexString(value));

        value = lib.callInt8Callback(cb2, (byte)-1, (byte)-2);
        assertEquals("Wrong byte return (hi bit)", (byte)-3, value);

        //多线程环境中执行callback
        final int[] called = {0};
        final boolean[] daemon = {false};
        final String[] name = { null };
        final ThreadGroup[] group = { null };
        final Thread[] t = { null };
        final String tname = "VoidCallbackThreaded";
        final boolean[] alive = {false};
        final boolean THREAD_DETACH_BUG = Platform.isMac() || (Platform.isLinux() && Platform.is64Bit());

        ThreadGroup testGroup = new ThreadGroup("Thread group for callVoidCallbackThreaded");
        CallbackThreadInitializer init = new CallbackThreadInitializer(true, false, tname, testGroup);
        TestLibrary.VoidCallback cb = new TestLibrary.VoidCallback() {
            @Override
            public void callback() {
                Thread thread = Thread.currentThread();
                daemon[0] = thread.isDaemon();
                name[0] = thread.getName();
                group[0] = thread.getThreadGroup();
                t[0] = thread;
                if (thread.isAlive()) {
                    alive[0] = true;
                }

                ++called[0];
                if (THREAD_DETACH_BUG && called[0] == 2) {
                    Native.detach(true);
                }
            }
        };

        Native.setCallbackThreadInitializer(cb, init);
        lib.callVoidCallbackThreaded(cb, 2, 2000, "callVoidCallbackThreaded", 0);
    }
}
