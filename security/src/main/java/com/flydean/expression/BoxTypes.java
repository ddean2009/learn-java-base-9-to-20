package com.flydean.expression;

/**
 * @author wayne
 * @version BoxTypes,  2020/7/23
 */
public class BoxTypes {



    public static void main(String[] args) {
        //boolean compare
        Boolean boolA=true;
        Boolean boolB=true;
        System.out.println(boolA==boolB);
        Boolean boolC=new Boolean(true);
        System.out.println(boolA==boolC);

        //Byte compare
        Byte byteA=1;
        Byte byteB=1;
        System.out.println(byteA==byteB);

        //Char compare
        Character charA=188;
        Character charB=188;
        System.out.println(charA==charB);

        String stringA="www.flydean.com";
        String stringB="www.flydean.com";
        System.out.println(stringA==stringB);
    }
}