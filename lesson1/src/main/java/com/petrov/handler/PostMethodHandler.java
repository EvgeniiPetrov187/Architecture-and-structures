package com.petrov.handler;


import com.petrov.HttpFinalStrings;
import com.petrov.config.Config;
import com.petrov.domain.HttpRequest;
import com.petrov.domain.HttpResponse;
import com.petrov.domain.ResponseCode;
import com.petrov.service.ResponseSerializer;
import com.petrov.service.SocketService;

@Handler(order = 1, method = "POST")
public class PostMethodHandler extends MethodHandler {

    public PostMethodHandler() {
    }

    public PostMethodHandler(String method, MethodHandler next, ResponseSerializer responseSerializer, Config config) {
        super(method, next, responseSerializer, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return HttpResponse.createBuilder()
                .withStatus(ResponseCode.OK)
                .withHeader(HttpFinalStrings.CONTENT_TYPE, HttpFinalStrings.HEADER)
                .withBody("<h1>POST method handled</h1>")
                .build();
    }

}
