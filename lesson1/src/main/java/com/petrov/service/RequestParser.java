package com.petrov.service;

import com.petrov.domain.HttpRequest;

import java.util.Deque;

public interface RequestParser {

    HttpRequest parseRequest(Deque<String> rawRequest);
}
