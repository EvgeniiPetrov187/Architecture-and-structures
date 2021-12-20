package com.petrov.command;
//command
public class Main {

    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        TurnOn turnOn = new TurnOn(lamp);
        TurnOff turnOff = new TurnOff(lamp);
        Control control = new Control();

        control.start(turnOn);
        control.start(turnOff);
    }
}
