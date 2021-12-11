package com.petrov.domain;

import com.petrov.SocketService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.petrov.Config.*;
import static com.petrov.Config.NOT_ALLOWED_H1;

public class HttpResponse {

    StringBuilder response = new StringBuilder();

    public void getResponse(HttpRequest httpRequest, SocketService socketService) {
        switch (httpRequest.getMethod()) {
            case GET:
                setResponseForGetMethod(httpRequest, socketService);
                break;
            case POST:
                setResponseForPostMethod(httpRequest, socketService);
                break;
            case PUT:
                setResponseForPutMethod(httpRequest, socketService);
                break;
            default:
                response.append(HTTP_NOT_ALLOWED + CONTENT_TYPE + NOT_ALLOWED_H1);
                socketService.writeResponse(response.toString());
                break;
        }
    }

    public void setResponseForGetMethod(HttpRequest httpRequest, SocketService socketService) {
        Path path = Paths.get(WWW, httpRequest.getUrl());
        if (!Files.exists(path)) {
            response.append(HTTP_NOT_FOUND + CONTENT_TYPE + NOT_FOUND_H1);
            socketService.writeResponse(response.toString());
            return;
        }

        response.append(HTTP_OK + CONTENT_TYPE);

        try {
            Files.readAllLines(path).forEach(response::append);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        socketService.writeResponse(response.toString());
    }

    public void setResponseForPostMethod(HttpRequest httpRequest, SocketService socketService) {
        //not ready
    }

    public void setResponseForPutMethod(HttpRequest httpRequest, SocketService socketService) {
        //not ready
    }
}
