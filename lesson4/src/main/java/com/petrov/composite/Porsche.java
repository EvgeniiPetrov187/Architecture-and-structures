package com.petrov.composite;

//composite
public class Porsche implements Car {

    private String name;

    private int power;

    public Porsche(String name, int power) {
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
