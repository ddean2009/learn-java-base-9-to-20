package com.flydean.lock;

/**
 * @author wayne
 * @version BookStaticLazy,  2020/7/30
 */
public class BookStaticLazy {

    private static class BookStaticHolder{
        private static BookStaticLazy bookStatic= new BookStaticLazy();
    }

    public static BookStaticLazy getBookStatic(){
        return BookStaticHolder.bookStatic;
    }
}