package com.flydean.threadsafe;


/**
 * @author wayne
 * @version ChildFactory3,  2020/8/14
 */
public final class ChildFactory3 {

    private static final ThreadLocal<Integer> ageHolder = ThreadLocal.withInitial(() -> 10);

    public static int getAge() {
        int localAge = ageHolder.get();
        if (localAge == 0) {
            throw new IllegalStateException("Error initializing age");
        }
        return localAge;
    }

    public static void main(String[] args) {
        int age = getAge();
    }
}
