package com.petrov.handler;

import com.petrov.config.Config;
import com.petrov.HttpFinalStrings;
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

    public SocketService getSocketService() {
        return socketService;
    }

    public void setSocketService(SocketService socketService) {
        this.socketService = socketService;
    }

    public MethodHandler(String method, MethodHandler next, ResponseSerializer responseSerializer, Config config) {
        this.method = method;
        this.next = next;
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
                    .withHeader(HttpFinalStrings.CONTENT_TYPE, HttpFinalStrings.HEADER)
                    .withBody(HttpFinalStrings.NOT_ALLOWED)
                    .build();
        }
        String rawResponse = responseSerializer.serialize(response);
        socketService.writeResponse(rawResponse);
    }

    protected abstract HttpResponse handleInternal(HttpRequest request);
}
