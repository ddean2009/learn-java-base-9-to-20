package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Flow;

/**
 * @author wayne
 * @version CustSubscription,  2020/5/3 5:41 下午
 */
@Slf4j
public class CustSubscription implements Flow.Subscription {

    private final Flow.Subscription subscription;

    public CustSubscription(Flow.Subscription subscription) {
        this.subscription=subscription;
    }

    @Override
    public void request(long n) {
        log.info("CustSubscription request {}",n);
        subscription.request(n);
    }

    @Override
    public void cancel() {
        log.info("CustSubscription cancel");
        subscription.cancel();
    }
}
