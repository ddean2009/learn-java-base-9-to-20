package com.flydean.file;

import org.junit.Test;

import java.io.*;

/**
 * @author wayne
 * @version ReadArray,  2020/8/15
 */
public class ReadArray {

    @Test
    public void testByte(){
        byte[] data = new byte[1024];
        System.out.println(data[1]);
    }

    public String wrongRead(InputStream in) throws IOException {
        byte[] data = new byte[1024];
        if (in.read(data) == -1) {
            throw new EOFException();
        }
        return new String(data, "UTF-8");
    }

    public String readArray(InputStream in) throws IOException {
        int offset = 0;
        int bytesRead = 0;
        byte[] data = new byte[1024];
        while ((bytesRead = in.read(data, offset, data.length - offset))
                != -1) {
            offset += bytesRead;
            if (offset >= data.length) {
                break;
            }
        }
        String str = new String(data, 0, offset, "UTF-8");
        return str;
    }

    public String readWithFully(FileInputStream fis) throws IOException {
        byte[] data = new byte[1024];
        DataInputStream dis = new DataInputStream(fis);
        dis.readFully(data);
        String str = new String(data, "UTF-8");
        return str;
    }
}
