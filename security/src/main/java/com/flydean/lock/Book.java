package com.flydean.lock;

/**
 * @author wayne
 * @version Book,  2020/7/30
 */
public class Book {

    private static Book book;

    public synchronized static Book getBook(){
        if(book==null){
            book = new Book();
        }
        return book;
    }
}
