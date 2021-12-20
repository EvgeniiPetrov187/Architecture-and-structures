package com.petrov.decorator;

//decorator
public class Main {

    public static void main(String[] args) {

        Volkswagen golf = new Golf();

        System.out.println(golf.getName());
        System.out.println(golf.getCost());

        Volkswagen golfGTI = new GolfGTI(golf);

        System.out.println(golfGTI.getName());
        System.out.println(golfGTI.getCost());
    }
}
