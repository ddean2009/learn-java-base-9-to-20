package com.flydean.threadsafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author wayne
 * @version ChildFactory,  2020/8/14
 */
public final class ChildFactory {
    private static int age;

    static {
        Thread ageInitializerThread = new Thread(()->{
            System.out.println("in thread running");
            age=10;
        });

        ageInitializerThread.start();
        try {
            ageInitializerThread.join();
        } catch (InterruptedException ie) {
            throw new AssertionError(ie);
        }
    }

    public static int getAge() {
        if (age == 0) {
            throw new IllegalStateException("Error initializing age");
        }
        return age;
    }

    public static void main(String[] args) {
        int age = getAge();
    }
}
