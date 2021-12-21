package com.petrov.chainofresponsibility;

//chain of responsibility
public class Main {
    public static void main(String[] args) {
        Volvo volvo = new Volvo(150);
        Subaru subaru = new Subaru(200);

        volvo.setNext(subaru);

        volvo.drive(120);
    }
}
