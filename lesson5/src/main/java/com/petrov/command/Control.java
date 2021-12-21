package com.petrov.command;
//command
public class Control {
    public void start(Command command){
        command.execute();
    }
}
