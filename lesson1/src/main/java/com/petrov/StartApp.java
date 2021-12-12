package com.petrov;

import com.petrov.config.Config;
import com.petrov.config.ConfigFactory;

import java.io.*;

// старт
public class StartApp {

    public static void main(String[] args) throws IOException {
        Config config = ConfigFactory.create(args);
        PrepareToStartApp.startApp(config);
    }
}