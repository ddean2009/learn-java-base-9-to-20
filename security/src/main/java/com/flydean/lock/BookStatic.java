package com.flydean.lock;

/**
 * @author wayne
 * @version BookStatic,  2020/7/30
 */
public class BookStatic {
    private static BookStatic bookStatic= new BookStatic();

    public static BookStatic getBookStatic(){
        return bookStatic;
    }
}
