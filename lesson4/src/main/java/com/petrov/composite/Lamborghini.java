package com.petrov.composite;

//composite
public class Lamborghini implements Car {

    private String name;

    private int power;

    public Lamborghini(String name, int power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPower() {
        return power;
    }
}
