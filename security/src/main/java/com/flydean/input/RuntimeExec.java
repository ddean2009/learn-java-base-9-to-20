package com.flydean.input;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author wayne
 * @version RuntimeExec,  2020/7/27
 */
public class RuntimeExec {

    public void wrongExec() throws IOException {
        String dir = System.getProperty("dir");
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(new String[] {"sh", "-c", "ls " + dir});
    }

    public void correctExec1() throws IOException {
        String dir = System.getProperty("dir");
        if (!Pattern.matches("[0-9A-Za-z@.]+", dir)) {
            // Handle error
        }
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(new String[] {"sh", "-c", "ls " + dir});
    }

    public void correctExec2(){
        String dir = System.getProperty("dir");
        switch (dir){
            case "/usr":
                System.out.println("/usr");
                break;
            case "/local":
                System.out.println("/local");
                break;
            default:
                break;
        }
    }


}
