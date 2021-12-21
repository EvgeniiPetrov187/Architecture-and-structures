package com.petrov.templatemethod;
//template method
public abstract class Transport {

    public void take() {
        this.buyTicket();
        this.travel();
    }

    public abstract void buyTicket();

    public abstract void travel();
}
