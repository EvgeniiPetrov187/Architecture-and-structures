package com.petrov.chainofresponsibility.state;
//state
public class Robot implements State {
    @Override
    public void getState(String state) {
        System.out.println("I'm a robot and I " + state);
    }
}
