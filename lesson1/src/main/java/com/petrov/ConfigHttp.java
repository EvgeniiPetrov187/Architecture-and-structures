package com.petrov;

public class ConfigHttp {
    public static final String HTTP_NOT_ALLOWED = "HTTP/1.1 405 METHOD_NOT_ALLOWED\n";
    public static final String HTTP_OK = "HTTP/1.1 200 OK\n";
    public static final String HTTP_NOT_FOUND = "HTTP/1.1 404 NOT_FOUND\n";
    public static final String CONTENT_TYPE = "Content-Type: text/html; charset=utf-8\n\n";
    public static final String NOT_ALLOWED_H1 = "<h1>Метод не поддерживается!</h1>";
    public static final String NOT_FOUND_H1 = "<h1>Файл не найден!</h1>";


}
