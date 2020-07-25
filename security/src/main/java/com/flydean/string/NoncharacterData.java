package com.flydean.string;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Base64;

/**
 * @author wayne
 * @version NoncharacterData,  2020/7/24
 */
public class NoncharacterData {

    @Test
    public void convertBigIntegerWrong(){
        BigInteger x = new BigInteger("1234567891011");
        System.out.println(x);
        byte[] byteArray = x.toByteArray();
        String s = new String(byteArray);
        byteArray = s.getBytes();
        x = new BigInteger(byteArray);
        System.out.println(x);
    }

    @Test
    public void convertBigIntegerRight(){
        BigInteger x = new BigInteger("1234567891011");
        String s = x.toString();  //转换成为可以存储的字符串
        byte[] byteArray = s.getBytes();
        String ns = new String(byteArray);
        x = new BigInteger(ns);
        System.out.println(x);
    }

    @Test
    public void convertBigIntegerWithBase64(){
        BigInteger x = new BigInteger("1234567891011");
        byte[] byteArray = x.toByteArray();
        String s = Base64.getEncoder().encodeToString(byteArray);
        byteArray = Base64.getDecoder().decode(s);
        x = new BigInteger(byteArray);
        System.out.println(x);

    }




}
