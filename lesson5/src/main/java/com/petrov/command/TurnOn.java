package com.petrov.command;
//command
public class TurnOn implements Command {
    private Lamp lamp;

    public TurnOn(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        this.lamp.turnOn();
    }

    @Override
    public void undo() {
        this.lamp.turnOff();
    }

    @Override
    public void redo() {
        execute();
    }
}
