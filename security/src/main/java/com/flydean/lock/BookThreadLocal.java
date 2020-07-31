package com.flydean.lock;

import lombok.experimental.Helper;

/**
 * @author wayne
 * @version BookThreadLocal,  2020/7/30
 */
public class BookThreadLocal {
    private static final ThreadLocal<BookThreadLocal> perThreadInstance =
            new ThreadLocal<>();
    private static BookThreadLocal bookThreadLocal;

    public static BookThreadLocal getBook(){
        if (perThreadInstance.get() == null) {
            createBook();
        }
        return bookThreadLocal;
    }

    private static synchronized void createBook(){
        if (bookThreadLocal == null) {
            bookThreadLocal = new BookThreadLocal();
        }
        perThreadInstance.set(bookThreadLocal);
    }
}
