package com.petrov.command;
//command
public class TurnOff implements Command {

    private Lamp lamp;

    public TurnOff(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        this.lamp.turnOff();
    }

    @Override
    public void undo() {
        this.lamp.turnOn();
    }

    @Override
    public void redo() {
        execute();
    }
}
