package com.petrov.service;

import com.petrov.domain.HttpResponse;

public interface ResponseSerializer {

    String serialize(HttpResponse response);
}

