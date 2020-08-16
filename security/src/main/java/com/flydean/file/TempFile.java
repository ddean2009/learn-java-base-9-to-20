package com.flydean.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * @author wayne
 * @version TempFile,  2020/8/14
 */
public class TempFile {

    public void wrongDelete() throws IOException {
        File f = File.createTempFile("tmpfile",".tmp");
        FileOutputStream fop = null;
        try {
            fop = new FileOutputStream(f);
            String str = "Data";
            fop.write(str.getBytes());
            fop.flush();
        } finally {
            // 因为Stream没有被关闭，所以文件在windows平台上面不会被删除
            f.deleteOnExit(); // 在JVM退出的时候删除临时文件

            if (fop != null) {
                try {
                    fop.close();
                } catch (IOException x) {
                    // Handle error
                }
            }
        }
    }

    public void correctDelete() throws IOException {
        Path tempFile = null;
            tempFile = Files.createTempFile("tmpfile", ".tmp");
            try (BufferedWriter writer =
                         Files.newBufferedWriter(tempFile, Charset.forName("UTF8"),
                                 StandardOpenOption.DELETE_ON_CLOSE)) {
                // Write to file
            }
        }

}
