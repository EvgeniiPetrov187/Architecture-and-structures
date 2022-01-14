package com.petrov.handler;

import com.petrov.HttpFinalStrings;
import com.petrov.config.Config;
import com.petrov.domain.HttpRequest;
import com.petrov.domain.HttpResponse;
import com.petrov.domain.ResponseCode;
import com.petrov.service.ResponseSerializer;
import com.petrov.service.SocketService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Handler(order = 0, method = "GET")
public class GetMethodHandler extends MethodHandler {

    public GetMethodHandler() {
    }

    public GetMethodHandler(String method, MethodHandler next, ResponseSerializer responseSerializer, Config config) {
        super(method, next, responseSerializer, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        Path path = Paths.get(config.getWwwHome(), request.getUrl());

        if (!Files.exists(path)) {
            return HttpResponse.createBuilder()
                    .withStatus(ResponseCode.NOT_FOUND)
                    .withHeader(HttpFinalStrings.CONTENT_TYPE, HttpFinalStrings.HEADER)
                    .withBody(HttpFinalStrings.NOT_FOUND)
                    .build();
        }

        StringBuilder sb = new StringBuilder();
        try {
            Files.readAllLines(path).forEach(sb::append);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        return HttpResponse.createBuilder()
                .withStatus(ResponseCode.OK)
                .withHeader(HttpFinalStrings.CONTENT_TYPE, HttpFinalStrings.HEADER)
                .withBody(sb.toString())
                .build();
    }
}
