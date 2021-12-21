package com.petrov.chainofresponsibility.state;
//state
public class Main {
    public static void main(String[] args) {
        Transformer transformer = new Transformer(new Robot());
        transformer.type("go");

        transformer.setState(new Car());
        transformer.type("drive");

        transformer.setState(new Plane());
        transformer.type("fly");
    }
}
