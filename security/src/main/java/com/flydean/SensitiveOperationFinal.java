package com.flydean;

/**
 * @author wayne
 * @version SensitiveOperationFinal
 */
public final class SensitiveOperationFinal {

    public SensitiveOperationFinal(){
        if(!doSecurityCheck()){
            throw new SecurityException("Security check failed!");
        }
    }

    //Security check return false
    private boolean doSecurityCheck(){
        return false;
    }

    public void storeMoney(){
        System.out.println("Store 1000000 RMB!");
    }

    final protected void finalize() {
    }
}
