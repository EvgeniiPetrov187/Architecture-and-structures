package com.petrov.bridge;

// bridge
public class Chevrolet implements Car {

    private Color color;

    public Chevrolet(Color color) {
        this.color = color;
    }

    @Override
    public void shine() {
        color.getColor();
    }
}
