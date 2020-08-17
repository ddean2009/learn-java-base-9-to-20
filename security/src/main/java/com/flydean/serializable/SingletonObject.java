package com.flydean.serializable;

import java.io.*;

/**
 * @author wayne
 * @version SingletonObject,  2020/8/17
 */
public class SingletonObject implements Serializable {
    private static final SingletonObject INSTANCE = new SingletonObject ();
    public static SingletonObject getInstance() {
        return INSTANCE;
    }
    private SingletonObject() {
    }

    public static Object deepCopy(Object obj) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            new ObjectOutputStream(bos).writeObject(obj);
            ByteArrayInputStream bin =
                    new ByteArrayInputStream(bos.toByteArray());
            return new ObjectInputStream(bin).readObject();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) {
        SingletonObject singletonObject= (SingletonObject) deepCopy(SingletonObject.getInstance());
        System.out.println(singletonObject == SingletonObject.getInstance());
    }
}
