package com.petrov.domain;

import com.petrov.SocketService;
import com.petrov.config.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.petrov.ConfigHttp.*;
import static com.petrov.HttpMethods.*;


public class HttpResponse {

    private StringBuilder response = new StringBuilder();

    private HttpRequest httpRequest;

    private SocketService socketService;

    private Config config;


    public HttpResponse(HttpRequest httpRequest, SocketService socketService, Config config) {
        this.httpRequest = httpRequest;
        this.socketService = socketService;
        this.config = config;
    }

    public HttpResponse() {
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public SocketService getSocketService() {
        return socketService;
    }

    public Config getConfig() {
        return config;
    }

    public StringBuilder getResponse(HttpRequest httpRequest, SocketService socketService, Config config) {
        if (httpRequest.getMethod().equalsIgnoreCase(String.valueOf(GET))) {
            setResponseForGetMethod(httpRequest, socketService, config);
        } else if (httpRequest.getMethod().equalsIgnoreCase(String.valueOf(POST))) {
            setResponseForPostMethod(httpRequest, socketService, config);
        } else if (httpRequest.getMethod().equalsIgnoreCase(String.valueOf(PUT))) {
            setResponseForPutMethod(httpRequest, socketService, config);
        } else {
            response.append(HTTP_NOT_ALLOWED + CONTENT_TYPE + NOT_ALLOWED_H1);
            socketService.writeResponse(response.toString());
        }
        return response;
    }

    private void setResponseForGetMethod(HttpRequest httpRequest, SocketService socketService, Config config) {
        Path path = Paths.get(config.getWwwHome(), httpRequest.getUrl());
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

    private void setResponseForPostMethod(HttpRequest httpRequest, SocketService socketService, Config config) {
        //not ready
    }

    private void setResponseForPutMethod(HttpRequest httpRequest, SocketService socketService, Config config) {
        //not ready
    }

    public static HttpResponse.ResponseBuilder createResponseBuilder() {
        return new HttpResponse.ResponseBuilder();
    }

    public static class ResponseBuilder {

        public static ResponseBuilder createResponseBuilder() {
            return new ResponseBuilder();
        }

        private final HttpResponse httpResponse;

        private ResponseBuilder() {
            this.httpResponse = new HttpResponse();
        }

        public HttpResponse.ResponseBuilder withResponse() {
            this.httpResponse.response = httpResponse.getResponse(httpResponse.httpRequest, httpResponse.socketService, httpResponse.config);
            return this;
        }
        public HttpResponse.ResponseBuilder withHttpRequest(HttpRequest httpRequest) {
            this.httpResponse.httpRequest = httpRequest;
            return this;
        }
        public HttpResponse.ResponseBuilder withConfig(Config config) {
            this.httpResponse.config = config;
            return this;
        }
        public HttpResponse.ResponseBuilder withSocketService(SocketService socketService) {
            this.httpResponse.socketService = socketService;
            return this;
        }

        public HttpResponse build() {
            return this.httpResponse;
        }
    }
}
