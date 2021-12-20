package com.petrov.handler;


import com.petrov.config.Config;
import com.petrov.domain.HttpRequest;
import com.petrov.domain.HttpResponse;
import com.petrov.domain.ResponseCode;
import com.petrov.service.ResponseSerializer;
import com.petrov.service.SocketService;

@Handler(order = 1)
public class PostMethodHandler extends MethodHandler {

    public PostMethodHandler() {
    }

    public PostMethodHandler(String method, MethodHandler next, SocketService socketService, ResponseSerializer responseSerializer, Config config) {
        super(method, next, socketService, responseSerializer, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return HttpResponse.createBuilder()
                .withStatus(ResponseCode.OK)
                .withHeader("Content-Type", "text/html; charset=utf-8")
                .withBody("<h1>POST method handled</h1>")
                .build();
    }

}
