package com.flydean;

import jdk.internal.vm.annotation.Contended;

/**
 * @author wayne
 * @version CacheLinePadded,  2020/6/19 10:16 上午
 */
public class CacheLinePadded {
    @Contended
    public  long a;
    public  long b;
}
