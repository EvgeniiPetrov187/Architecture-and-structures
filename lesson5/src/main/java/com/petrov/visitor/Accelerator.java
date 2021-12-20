package com.petrov.visitor;
//visitor
public class Accelerator implements CarAction {
    @Override
    public void driveDodge(Dodge dodge) {
        dodge.press();
    }

    @Override
    public void drivePontiac(Pontiac pontiac) {
        pontiac.touch();
    }
}
