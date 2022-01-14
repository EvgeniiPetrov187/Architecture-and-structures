package com.petrov.handler;

import com.petrov.StartApp;
import com.petrov.config.Config;
import com.petrov.domain.HttpRequest;
import com.petrov.domain.HttpResponse;
import com.petrov.service.ResponseSerializer;
import com.petrov.service.SocketService;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.*;


public class MethodHandlerFactory {

    public static MethodHandler create(ResponseSerializer responseSerializer, Config config) {
        Reflections reflections = new Reflections(StartApp.class.getPackage().getName());
        List<Class<?>> classes = new ArrayList<>(reflections.getTypesAnnotatedWith(Handler.class));

        MethodHandler prev = null;
        classes.sort(Comparator.comparingInt(MethodHandlerFactory::getOrder).reversed());
        try {
            for (Class<?> clazz : classes) {
                Constructor<?> constructor = clazz.getConstructor(String.class, MethodHandler.class, ResponseSerializer.class, Config.class);
                prev = (MethodHandler) constructor.newInstance(getMethod(clazz), prev, responseSerializer, config);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return prev;
    }

    private static int getOrder(Class<?> clazz) {
        return clazz.getAnnotation(Handler.class).order();
    }

    private static String getMethod(Class<?> clazz) {
        return clazz.getAnnotation(Handler.class).method();
    }
}