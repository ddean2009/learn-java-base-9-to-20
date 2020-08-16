package com.flydean.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * @author wayne
 * @version StreamProcesser,  2020/8/15
 */
public class StreamProcesser implements Runnable{
    private final InputStream is;
    private final PrintStream os;

    StreamProcesser(InputStream is, PrintStream os){
        this.is=is;
        this.os=os;
    }

    @Override
    public void run() {
        try {
            int c;
            while ((c = is.read()) != -1)
                os.print((char) c);
        } catch (IOException x) {
            // Handle error
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec("vscode");

        Thread errorGobbler
                = new Thread(new StreamProcesser(proc.getErrorStream(), System.err));

        Thread outputGobbler
                = new Thread(new StreamProcesser(proc.getInputStream(), System.out));

        errorGobbler.start();
        outputGobbler.start();

        int exitVal = proc.waitFor();
        errorGobbler.join();
        outputGobbler.join();
    }
}
