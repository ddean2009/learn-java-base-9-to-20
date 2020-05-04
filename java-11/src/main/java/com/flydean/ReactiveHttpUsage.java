package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

/**
 * @author wayne
 * @version ReactiveHttpUsage,  2020/5/3 3:15 下午
 */
@Slf4j
public class ReactiveHttpUsage {

    @Test
    public void testCustPost() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest.BodyPublisher requestBody = HttpRequest.BodyPublishers
                .ofString("{ 我是body }");
        CustBodyPublisher custBodyPublisher= new CustBodyPublisher(requestBody);
        HttpRequest postRequest = HttpRequest.newBuilder()
                .POST(custBodyPublisher)
                .uri(URI.create("http://www.flydean.com"))
                .build();

        HttpResponse<String> response = client
                .send(postRequest, HttpResponse.BodyHandlers.ofString());

        log.info("response {}",response);
    }


}
