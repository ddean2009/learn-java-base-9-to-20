package com.flydean.serializable;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @author wayne
 * @version FieldRangeObject,  2020/8/17
 */
public class FieldRangeObject implements Serializable {

    private int age;

    public FieldRangeObject(int age){
        if(age < 0 || age > 100){
            throw new IllegalArgumentException("age范围不对！");
        }
        this.age=age;
    }

    private  void readObject(java.io.ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = s.readFields();
        int age = fields.get("age", 0);
        if (age > 100 || age < 0) {
            throw new InvalidObjectException("age范围不对!");
        }
        this.age = age;
    }
}
