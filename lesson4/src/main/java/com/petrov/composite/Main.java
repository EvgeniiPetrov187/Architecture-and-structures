package com.petrov.composite;

//composite
public class Main {
    public static void main(String[] args) {
        Lamborghini miura = new Lamborghini("Miura", 360);
        Porsche boxter = new Porsche("Boxter", 250);

        MyGarage garage = new MyGarage();

        garage.addCar(miura);
        garage.addCar(boxter);

        garage.showMyCars(garage.getCars());
    }
}
