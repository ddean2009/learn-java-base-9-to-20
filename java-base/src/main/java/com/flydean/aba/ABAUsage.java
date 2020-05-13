package com.flydean.aba;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author wayne
 * @version ABAUsage,  2020/5/10 7:52 下午
 */
@Slf4j
public class ABAUsage {

    @Test
    public void useABAReference(){
        CustUser a= new CustUser();
        CustUser b= new CustUser();
        CustUser c= new CustUser();
        AtomicReference<CustUser> atomicReference= new AtomicReference<>(a);
        log.info("{}",atomicReference.compareAndSet(a,b));
        log.info("{}",atomicReference.compareAndSet(b,a));
        a.setName("change for new name");
        log.info("{}",atomicReference.compareAndSet(a,c));
    }

    @Test
    public void useABAStampReference(){
        Object a= new Object();
        Object b= new Object();
        Object c= new Object();
        AtomicStampedReference<Object> atomicStampedReference= new AtomicStampedReference(a,0);
        log.info("{}",atomicStampedReference.compareAndSet(a,b,0,1));
        log.info("{}",atomicStampedReference.compareAndSet(b,a,1,2));
        log.info("{}",atomicStampedReference.compareAndSet(a,c,0,1));
    }
}
