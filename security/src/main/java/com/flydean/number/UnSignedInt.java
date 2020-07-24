package com.flydean.number;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author wayne
 * @version UnSignedInt,  2020/7/23
 */
public class UnSignedInt {

    public int readIntWrong(DataInputStream is) throws IOException {
        return is.readInt();
    }

    public long readIntRight(DataInputStream is) throws IOException{
        return is.readInt() & 0xFFFFFFFFL; // Mask with 32 one-bits
    }
}
