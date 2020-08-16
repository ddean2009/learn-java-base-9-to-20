package com.flydean.file;

import java.nio.CharBuffer;

/**
 * @author wayne
 * @version BufferRead,  2020/8/14
 */
public class BufferRead {

    public CharBuffer getBuffer(){
         char[] dataArray = new char[10];
         return CharBuffer.wrap(dataArray);
    }

    public CharBuffer getBuffer1(){
        char[] dataArray = new char[10];
        return CharBuffer.wrap(dataArray).asReadOnlyBuffer();
    }

    public CharBuffer getBuffer2(){
        char[] dataArray = new char[10];
        CharBuffer cb = CharBuffer.allocate(dataArray.length);
        cb.put(dataArray);
        return cb;
    }
}
