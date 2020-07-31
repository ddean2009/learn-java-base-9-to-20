package com.flydean.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wayne
 * @version DiffLockWithReentrantLock,  2020/7/30
 */
public class DiffLockWithReentrantLock {

    private int amount;
    private final Lock lock = new ReentrantLock();

    public DiffLockWithReentrantLock(int amount){
        this.amount=amount;
    }

    private void transfer(DiffLockWithReentrantLock target, int transferAmount)
            throws InterruptedException {
        while (true) {
            if (this.lock.tryLock()) {
                try {
                    if (target.lock.tryLock()) {
                        try {
                            if(amount< transferAmount){
                                System.out.println("余额不足！");
                            }else{
                                amount=amount-transferAmount;
                                target.amount=target.amount+transferAmount;
                            }
                            break;
                        } finally {
                            target.lock.unlock();
                        }
                    }
                } finally {
                    this.lock.unlock();
                }
            }
            //随机sleep一定的时间，保证可以释放掉锁
            Thread.sleep(1000+new Random(1000L).nextInt(1000));
        }
    }

}
