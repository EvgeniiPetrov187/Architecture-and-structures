package com.petrov.decorator;

public class GolfGTI implements Volkswagen{

    private Volkswagen volkswagen;

    private String name;
    private int cost;

    public GolfGTI(Volkswagen volkswagen){
        this.volkswagen = volkswagen;
    }

    @Override
    public String getName() {
        return this.volkswagen.getName()+" GTI";
    }

    @Override
    public int getCost() {
        return this.volkswagen.getCost() + 10000;
    }
}
