package com.flydean.threadsafe;

/**
 * @author wayne
 * @version ChildFactory2,  2020/8/14
 */
public final class ChildFactory2 {
    private static int age;

    static {
            System.out.println("in thread running");
            age=10;
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
