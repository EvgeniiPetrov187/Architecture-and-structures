package com.petrov.bridge;

// bridge
public class Main {
    public static void main(String[] args) {
        Black black = new Black();
        Green green = new Green();
        Chevrolet chevrolet = new Chevrolet(black);
        Jeep jeep = new Jeep(green);

        chevrolet.shine();
        jeep.shine();
    }

}
