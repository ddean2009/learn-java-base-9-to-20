package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.net.http.HttpRequest;
import java.nio.ByteBuffer;
import java.util.concurrent.Flow;

/**
 * @author wayne
 * @version CustBodyPublisher,  2020/5/3 5:29 下午
 */
@Slf4j
public class CustBodyPublisher implements HttpRequest.BodyPublisher {

    private final HttpRequest.BodyPublisher bodyPublisher;

    public CustBodyPublisher(HttpRequest.BodyPublisher bodyPublisher){
        this.bodyPublisher=bodyPublisher;
    }
    @Override
    public long contentLength() {
        long contentLength=bodyPublisher.contentLength();
        log.info("contentLength:{}",contentLength);
        return contentLength;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super ByteBuffer> subscriber) {
        log.info("CustBodyPublisher subscribe {}",subscriber);
        bodyPublisher.subscribe(new CustSubscriber(subscriber));
    }
}
