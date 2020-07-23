package com.flydean.finalizer;

import org.junit.Test;

/**
 * @author wayne
 * @version SensitiveUsage
 */
public class SensitiveUsage {

    public static void main(String[] args) {
        SensitiveOperation sensitiveOperation = new SensitiveOperation();
        sensitiveOperation.storeMoney();
    }

    @Test
    public void testFinalizer() throws InterruptedException {
        try {
        SensitiveOperation sensitiveOperation = new SensitiveOperationFinalizer();
            sensitiveOperation.storeMoney();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.gc();
        Thread.sleep(10000);
    }
}
