package com.petrov.visitor;
//visitor
public class Dodge implements Car{
    public void press(){
        System.out.println("GRRR!");
    }

    @Override
    public void acceptCar(CarAction carAction) {
        carAction.driveDodge(this);
    }
}
