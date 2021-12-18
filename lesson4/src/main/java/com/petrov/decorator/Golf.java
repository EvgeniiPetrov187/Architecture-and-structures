package com.petrov.decorator;

//decorator
public class Golf implements Volkswagen{

    private Volkswagen volkswagen;

    private String name;
    private int cost;

    @Override
    public String getName() {
        return "Golf";
    }

    @Override
    public int getCost() {
        return 15000;
    }
}
