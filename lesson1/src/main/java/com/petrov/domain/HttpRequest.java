package com.petrov.domain;

import java.util.Map;

public class HttpRequest {

    private String method;

    private String url;

    private Map<String, String> headers;

    private String body;

    public HttpRequest(String method, String url, Map<String, String> headers, String body) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
    }

    public HttpRequest(){}

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }

    public static RequestBuilder createRequestBuilder() {
        return new RequestBuilder();
    }

    public static class RequestBuilder {

        private final HttpRequest httpRequest;

        private RequestBuilder() {
            this.httpRequest = new HttpRequest();
        }

        public RequestBuilder withMethod(String method) {
            this.httpRequest.method = method;
            return this;
        }

        public RequestBuilder withUrl(String url) {
            this.httpRequest.url = url;
            return this;
        }

        public RequestBuilder withHeaders(Map<String, String> headers) {
            this.httpRequest.headers = headers;
            return this;
        }

        public RequestBuilder withBody(String body) {
            this.httpRequest.body = body;
            return this;
        }

        public HttpRequest build() {
            return this.httpRequest;
        }
    }
}

