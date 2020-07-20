package com.flydean;

/**
 * @author wayne
 * @version SensitiveOperationFlag
 */
public class SensitiveOperationFlag {

    private volatile boolean flag= false;

    public SensitiveOperationFlag(){
        if(!doSecurityCheck()){
            throw new SecurityException("Security check failed!");
        }
        flag=true;
    }

    //Security check return false
    private boolean doSecurityCheck(){
        return false;
    }

    public void storeMoney(){
        if(!flag){
            System.out.println("Object is not initiated yet!");
            return;
        }
        System.out.println("Store 1000000 RMB!");
    }
}
