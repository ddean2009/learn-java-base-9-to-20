package com.flydean.lock;

/**
 * @author wayne
 * @version BookDLC,  2020/7/30
 */
public class BookDLC {
    private volatile static BookDLC bookDLC;

    public static BookDLC getBookDLC(){
        if(bookDLC == null ){
            synchronized (BookDLC.class){
                if(bookDLC ==null){
                    bookDLC=new BookDLC();
                }
            }
        }
        return bookDLC;
    }
}