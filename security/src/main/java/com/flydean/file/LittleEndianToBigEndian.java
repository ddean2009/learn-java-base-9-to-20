package com.flydean.file;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author wayne
 * @version LittleEndianToBigEndian,  2020/8/15
 */
public class LittleEndianToBigEndian {

    public void method1(InputStream inputStream) throws IOException {
        try(DataInputStream dis = new DataInputStream(inputStream)) {
            byte[] buffer = new byte[4];
            int bytesRead = dis.read(buffer);  // Bytes are read into buffer
            if (bytesRead != 4) {
                throw new IOException("Unexpected End of Stream");
            }
            int serialNumber =
                    ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN).getInt();
        }
    }

    public  int reverse(int i) {
        return Integer.reverseBytes(i);
    }
}
