package com.flydean.lock;

/**
 * @author wayne
 * @version DiffLockOrder,  2020/7/30
 */
public class DiffLockOrder {

    private int amount;

    public DiffLockOrder(int amount){
       this.amount=amount;
    }

    public void transfer(DiffLockOrder target,int transferAmount){
        synchronized (this){
            synchronized (target){
                if(amount< transferAmount){
                    System.out.println("余额不足！");
                }else{
                    amount=amount-transferAmount;
                    target.amount=target.amount+transferAmount;
                }
            }
        }
    }

    public static void main(String[] args) {
        DiffLockOrder account1 = new DiffLockOrder(1000);
        DiffLockOrder account2 = new DiffLockOrder(500);

        Runnable target1= ()->account1.transfer(account2,200);
        Runnable target2= ()->account2.transfer(account1,100);
        new Thread(target1).start();
        new Thread(target2).start();
    }
}
