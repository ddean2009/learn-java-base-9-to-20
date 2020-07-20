package com.flydean;

/**
 * @author wayne
 * @version SensitiveOperationFinalizer
 */
public class SensitiveOperationFinalizer extends  SensitiveOperation{

    public SensitiveOperationFinalizer(){
    }

    @Override
    protected void finalize() {
        System.out.println("We can still do store Money action!");
        this.storeMoney();
        System.exit(0);
    }
}
