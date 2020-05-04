package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 * @author wayne
 * @version HttpUsage,  2020/5/1 5:33 下午
 */
@Slf4j
public class HttpUsage {

    @Test
    public void useSyncHttp() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(5))
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest getRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://www.flydean.com"))
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36")
                .build();

        HttpRequest.BodyPublisher requestBody = HttpRequest.BodyPublishers
                .ofString("{ 我是body }");
        HttpRequest postRequest = HttpRequest.newBuilder()
                .POST(requestBody)
                .uri(URI.create("http://www.flydean.com"))
                .build();


        HttpResponse<String> response = client.send( getRequest, HttpResponse.BodyHandlers.ofString());
        String respnseBody = response.body();
        log.info(respnseBody);


    }

    @Test
    public void useAsyncHttp()  {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(5))
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        CompletableFuture<Void> completableFuture=checkUri(client,URI.create("http://www.flydean.com"));
        //获取completableFuture的值
//        completableFuture.get();
        completableFuture.join();
    }

    private CompletableFuture<Void> checkUri(HttpClient httpClient, URI uri){
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36")
                .build();

        return httpClient.sendAsync(request,HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::statusCode)
                .thenApply(statusCode -> statusCode == 200 )
                .exceptionally(ex -> false)
                .thenAccept(valid ->
                {
                    if (valid) {
                        log.info("uri {} is valid",uri);
                    } else {
                        log.info("uri {} is not valid", uri);
                    }
                });
    }
}
