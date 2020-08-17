package com.flydean.serializable;

import java.io.*;

/**
 * @author wayne
 * @version SingletonObject2,  2020/8/17
 */
public class SingletonObject2 implements Serializable {
    private static final SingletonObject2 INSTANCE = new SingletonObject2();
    public static SingletonObject2 getInstance() {
        return INSTANCE;
    }
    private SingletonObject2() {
    }
    protected final Object readResolve() throws NotSerializableException {
        return INSTANCE;
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
        SingletonObject2 singletonObject= (SingletonObject2) deepCopy(SingletonObject2.getInstance());
        System.out.println(singletonObject == SingletonObject2.getInstance());
    }
}
