package com.flydean.expression;

import java.io.File;

/**
 * @author wayne
 * @version ReturnValue,  2020/7/23
 */
public class ReturnValue {

    public void deleteFileWrong(){
        File file= new File("/tmp/www.flydean.com.txt");
        file.delete();
        System.out.println("File delete success!");
    }

    public void deleteFileRight(){
        File file= new File("/tmp/www.flydean.com.txt");
        if(file.delete()){
            System.out.println("File delete success!");
        }
    }

    public void stringReplaceWrong(){
        String url="www.flydean.com";
        url.replace("www","WWW");
        System.out.println("replaced url..."+url);
    }
    public void stringReplaceRight(){
        String url="www.flydean.com";
        url=url.replace("www","WWW");
        System.out.println("replaced url..."+url);
    }
}
