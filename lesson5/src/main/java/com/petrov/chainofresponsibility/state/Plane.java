package com.petrov.chainofresponsibility.state;
//state
public class Plane implements State {
    @Override
    public void getState(String state) {
        System.out.println("I'm a plane and I " + state);
    }
}
