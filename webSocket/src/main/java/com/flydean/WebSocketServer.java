package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wayne
 * @version WebSocketServer,  2021/9/13
 */
@Slf4j
public class WebSocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        try {
            log.info("Server has started on 127.0.0.1:80.\r\nWaiting for a connection...");
            Socket client = server.accept();
            log.info("A client connected.");
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }
}
