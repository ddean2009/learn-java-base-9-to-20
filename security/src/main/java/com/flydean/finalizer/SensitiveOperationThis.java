package com.flydean.finalizer;

/**
 * @author wayne
 * @version SensitiveOperationThis
 */
public class SensitiveOperationThis {

    public SensitiveOperationThis(){
        this(doSecurityCheck());
    }

    private SensitiveOperationThis(boolean secure) {
    }

    //Security check return false
    private static boolean doSecurityCheck(){
         throw new SecurityException("Security check failed!");
    }

    public void storeMoney(){
        System.out.println("Store 1000000 RMB!");
    }
}
