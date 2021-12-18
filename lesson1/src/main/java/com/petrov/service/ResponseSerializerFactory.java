package com.petrov.service;

public class ResponseSerializerFactory {

    public static ResponseSerializer createResponseSerializer() {
        return new ResponseSerializerImpl();
    }
}
