package com.petrov.chainofresponsibility.state;
//state
public class Car implements State {
    @Override
    public void getState(String state) {
        System.out.println("I'm a car and I " + state);
    }
}
