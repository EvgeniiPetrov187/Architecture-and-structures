package com.petrov.chainofresponsibility.state;
//state
public class Transformer {
    private State state;

    public Transformer(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void type(String more){
        this.state.getState(more);
    }
}
