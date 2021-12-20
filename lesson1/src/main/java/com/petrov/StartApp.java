package com.petrov;

import com.petrov.config.Config;
import com.petrov.config.ConfigFactory;

// старт
public class StartApp {

    public static void main(String[] args) {
        Config config = ConfigFactory.create(args);
        PrepareToStartApp.startApp(config);
    }
}