package com.flydean.exception;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wayne
 * @version ThrowException,  2020/7/28
 */
public class ThrowException {

    private static Throwable throwable;

    private ThrowException() throws Throwable {
        throw throwable;
    }

    public static synchronized void undeclaredThrow(Throwable throwable) {

        ThrowException.throwable = throwable;
        try {
                ThrowException.class.newInstance();
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
        } finally {
            ThrowException.throwable = null;
        }
    }

    public static synchronized void declaredThrow(Throwable throwable) {

        ThrowException.throwable = throwable;
        try {
            Constructor constructor =
                    ThrowException.class.getConstructor(new Class<?>[0]);
            constructor.newInstance();
        } catch (InstantiationException e) {
        } catch (InvocationTargetException e) {
            System.out.println("catch exception!");
        } catch (NoSuchMethodException e) {
        } catch (IllegalAccessException e) {
        } finally {
            ThrowException.throwable = null;
        }
    }



    public static void main(String[] args) {
        ThrowException.undeclaredThrow(
                new Exception("Any checked exception"));
    }
}

