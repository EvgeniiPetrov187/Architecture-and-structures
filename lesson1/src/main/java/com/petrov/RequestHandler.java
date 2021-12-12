package com.petrov;

import com.petrov.domain.HttpRequest;
import com.petrov.domain.HttpResponse;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;
    private final RequestParser requestParser;

    public RequestHandler(SocketService socketService, RequestParser requestParser) {
        this.socketService = socketService;
        this.requestParser = requestParser;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.getResponse(httpRequest, socketService);

        try {
            socketService.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("Client disconnected!");
    }
}

