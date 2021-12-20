package com.flydean;

public class JNIUsage {

    public native void printMsg();

    public static void main(String[] args) {
        //加载C文件
        System.loadLibrary("JNIUsage");
        JNIUsage jniUsage = new JNIUsage();
        jniUsage.printMsg();
    }
}
