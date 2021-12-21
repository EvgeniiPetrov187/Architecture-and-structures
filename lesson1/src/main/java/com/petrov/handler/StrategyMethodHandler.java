package com.petrov.handler;

import com.petrov.config.Config;
import com.petrov.domain.HttpRequest;
import com.petrov.domain.HttpResponse;
import com.petrov.service.ResponseSerializer;
import com.petrov.service.SocketService;

import java.util.function.Function;

public class StrategyMethodHandler extends MethodHandler {

    private final Function<HttpRequest, HttpResponse> strategy;

    public StrategyMethodHandler(String method, MethodHandler next,
                                 SocketService socketService, ResponseSerializer responseSerializer, Config config,
                                 Function<HttpRequest, HttpResponse> strategy) {
        super(method, next, socketService, responseSerializer, config);
        this.strategy = strategy;
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return strategy.apply(request);
    }
}
