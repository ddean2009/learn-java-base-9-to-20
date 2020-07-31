package com.flydean.lock;

/**
 * @author wayne
 * @version LockWithPrivateStatic,  2020/7/30
 */
public class LockWithPrivateStatic {

    private int amount;

    private static final Object lock = new Object();

    public LockWithPrivateStatic(int amount){
       this.amount=amount;
    }

    public void transfer(LockWithPrivateStatic target, int transferAmount){
        synchronized (lock) {
            if (amount < transferAmount) {
                System.out.println("余额不足！");
            } else {
                amount = amount - transferAmount;
                target.amount = target.amount + transferAmount;
            }
        }
    }
}
