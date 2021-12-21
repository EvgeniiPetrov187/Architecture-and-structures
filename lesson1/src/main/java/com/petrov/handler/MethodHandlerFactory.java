package com.petrov.handler;

import com.petrov.config.Config;
import com.petrov.domain.HttpRequest;
import com.petrov.domain.HttpResponse;
import com.petrov.service.ResponseSerializer;
import com.petrov.service.SocketService;
import org.reflections.Reflections;

import java.util.*;


public class MethodHandlerFactory {

    public static MethodHandler create(SocketService socketService, ResponseSerializer responseSerializer, Config config) {
        Reflections reflections = new Reflections("com.petrov");
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Handler.class);
        List<MethodHandler> handlers = new ArrayList<>();
        Class[] params = {String.class, MethodHandler.class, SocketService.class, ResponseSerializer.class, Config.class};
        MethodHandler handler = new MethodHandler() {
            @Override
            protected HttpResponse handleInternal(HttpRequest request) {
                return null;
            }
        };
        int count = 0;
        try {
            for (Class cls : classSet) {
                if (count == 0) {
                    handler = (MethodHandler) cls.getConstructor(params).newInstance("GET", handler, socketService, responseSerializer, config);
                    handlers.add(handler);
                } else if (count == 1) {
                    handler = (MethodHandler) cls.getConstructor(params).newInstance("POST", handler, socketService, responseSerializer, config);
                    handlers.add(handler);
                } else if (count == 2) {
                    handler = (MethodHandler) cls.getConstructor(params).newInstance("PUT", handler, socketService, responseSerializer, config);
                    handlers.add(handler);
                }
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        handlers.sort((o1, o2) -> {
            if (o1.getClass().getAnnotation(Handler.class).order() > o2.getClass().getAnnotation(Handler.class).order()) {
                return 1;
            } else if (o1.getClass().getAnnotation(Handler.class).order() < o2.getClass().getAnnotation(Handler.class).order()) {
                return -1;
            } else {
                return 0;
            }
        });

        return handlers.get(0);
    }
}