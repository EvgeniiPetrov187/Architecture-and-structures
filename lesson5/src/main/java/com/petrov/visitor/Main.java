package com.petrov.visitor;
//visitor
public class Main {
    public static void main(String[] args) {
        Pontiac pontiac = new Pontiac();
        Dodge dodge = new Dodge();

        Accelerator accelerator = new Accelerator();

        dodge.acceptCar(accelerator);
        pontiac.acceptCar(accelerator);
    }
}
