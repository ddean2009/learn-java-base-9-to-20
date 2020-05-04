package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.util.concurrent.Flow;

/**
 * @author wayne
 * @version CustSubscriber,  2020/5/3 5:33 下午
 */
@Slf4j
public class CustSubscriber implements Flow.Subscriber<ByteBuffer> {

    private final Flow.Subscriber subscriber;

    public CustSubscriber(Flow.Subscriber<? super ByteBuffer> subscriber) {
        this.subscriber=subscriber;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        log.info("CustSubscriber onSubscribe {}",subscription);
        subscriber.onSubscribe(new CustSubscription(subscription));
    }

    @Override
    public void onNext(ByteBuffer item) {
        log.info("CustSubscriber onNext length {}",item.array().length);
        subscriber.onNext(item);
    }

    @Override
    public void onError(Throwable throwable) {
        log.info("CustSubscriber onError",throwable);
        subscriber.onError(throwable);
    }

    @Override
    public void onComplete() {
        log.info("CustSubscriber onComplete");
        subscriber.onComplete();
    }
}
