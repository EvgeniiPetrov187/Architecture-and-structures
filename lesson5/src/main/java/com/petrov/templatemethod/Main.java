package com.petrov.templatemethod;
//template method
public class Main {
    public static void main(String[] args) {
        Transport bus = new Bus();
        bus.take();

        Transport train = new Train();
        train.take();
    }
}
