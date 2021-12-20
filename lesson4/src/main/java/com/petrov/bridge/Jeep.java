package com.petrov.bridge;

// bridge
public class Jeep implements Car{

    private Color color;

    public Jeep(Color color) {
        this.color = color;
    }

    @Override
    public void shine() {
        color.getColor();
    }
}
