package com.flydean.lock;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wayne
 * @version DiffLockWithOrder,  2020/7/30
 */
public class DiffLockWithOrder {

    private int amount;
    private final long id; // 唯一ID，用来排序
    private static final AtomicLong nextID = new AtomicLong(0); // 用来生成ID

    public DiffLockWithOrder(int amount){
       this.amount=amount;
        this.id = nextID.getAndIncrement();
    }

    public int compareTo(DiffLockWithOrder ba) {
        return (this.id > ba.id) ? 1 : (this.id < ba.id) ? -1 : 0;
    }

    public void transfer(DiffLockWithOrder target, int transferAmount){
        DiffLockWithOrder fist, second;

        if (compareTo(target) < 0) {
            fist = this;
            second = target;
        } else {
            fist = target;
            second = this;
        }

        synchronized (fist){
            synchronized (second){
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
        DiffLockWithOrder account1 = new DiffLockWithOrder(1000);
        DiffLockWithOrder account2 = new DiffLockWithOrder(500);

        Runnable target1= ()->account1.transfer(account2,200);
        Runnable target2= ()->account2.transfer(account1,100);
        new Thread(target1).start();
        new Thread(target2).start();
    }
}
