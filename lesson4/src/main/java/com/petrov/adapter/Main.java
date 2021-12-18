package com.petrov.adapter;

//adapter
public class Main {
    public static void main(String[] args) {
        Yamaha yamaha = new Yamaha();
        YamahaAdapter yamahaAdapter = new YamahaAdapter(yamaha);
        Driver driver = new Driver();

        driver.drive(yamahaAdapter);
    }
}
