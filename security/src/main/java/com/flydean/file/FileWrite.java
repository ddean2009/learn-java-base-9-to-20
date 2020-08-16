package com.flydean.file;

/**
 * @author wayne
 * @version FileWrite,  2020/8/15
 */
public class FileWrite {

    public void writeInt(int value){
        int intValue = Integer.valueOf(value);
        if (intValue < 0 || intValue > 255) {
            throw new ArithmeticException("Value超出范围");
        }
        System.out.write(value);
        System.out.flush();
    }

}
