package com.petrov.visitor;
//visitor
public class Pontiac implements Car {
    public void touch(){
        System.out.println("WHEEE!");
    }

    @Override
    public void acceptCar(CarAction carAction) {
        carAction.drivePontiac(this);
    }
}
