package com.flydean.method;

import java.util.HashMap;

/**
 * @author wayne
 * @version Girl,  2020/7/28
 */
public class Girl {

    private final int age;

    public Girl(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Girl)) {
            return false;
        }
        Girl cc = (Girl)o;
        return cc.age == age;
    }

    public int hashCode() {
        return age;
    }

    public static void main(String[] args) {

        HashMap<Girl,Integer> hashMap= new HashMap<>();
        hashMap.put(new Girl(20), 20);
        System.out.println(hashMap.get(new Girl(20)));
    }
}
