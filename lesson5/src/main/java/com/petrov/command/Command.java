package com.petrov.command;
//command
public interface Command {
    void execute();
    void undo();
    void redo();
}
