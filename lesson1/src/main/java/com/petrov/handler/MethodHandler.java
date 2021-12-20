package com.petrov.handler;

import com.petrov.config.Config;
import com.petrov.domain.HttpRequest;
import com.petrov.domain.HttpResponse;
import com.petrov.domain.ResponseCode;
import com.petrov.service.ResponseSerializer;
import com.petrov.service.SocketService;

public abstract class MethodHandler {

    private String method;

    private MethodHandler next;

    protected SocketService socketService;

    protected ResponseSerializer responseSerializer;

    protected Config config;

    public MethodHandler() {
    }

    public MethodHandler(String method, MethodHandler next, SocketService socketService, ResponseSerializer responseSerializer, Config config) {
        this.method = method;
        this.next = next;
        this.socketService = socketService;
        this.responseSerializer = responseSerializer;
        this.config = config;
    }

    public void handle(HttpRequest request) {
        HttpResponse response;
        if (method.equals(request.getMethod())) {
            response = handleInternal(request);
        } else if (next != null) {
            next.handle(request);
            return;
        } else {
            response = HttpResponse.createBuilder()
                    .withStatus(ResponseCode.METHOD_NOT_ALLOWED)
                    .withHeader("Content-Type", "text/html; charset=utf-8")
                    .withBody("<h1>Метод не поддерживается!</h1>")
                    .build();
        }
        String rawResponse = responseSerializer.serialize(response);
        socketService.writeResponse(rawResponse);
    }

    protected abstract HttpResponse handleInternal(HttpRequest request);
}
