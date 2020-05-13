package com.flydean.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author wayne
 * @version CustUser,  2020/5/11 5:02 下午
 */
@Slf4j
@Data
@AllArgsConstructor
public class CustUserV2 implements java.io.Serializable{

    private static final long serialVersionUID = -178469307574906636L;

    private String name;
    private String address;
    private int age;

    private void writeObject(ObjectOutputStream stream)
            throws IOException
    {
        //给age加密
        age = age + 2;
        log.info("age is {}", age);
        stream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream stream)
            throws IOException, ClassNotFoundException
    {
        stream.defaultReadObject();
        log.info("age is {}", age);
        //给age解密
        age = age - 2;
    }

}
