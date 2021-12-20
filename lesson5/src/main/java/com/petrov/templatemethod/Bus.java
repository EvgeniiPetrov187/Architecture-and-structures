package com.petrov.templatemethod;
//template method
public class Bus extends Transport{

    public void buyTicket(){
        System.out.println("One ticket please");
    }
    public void travel(){
        System.out.println("R-r-r-r");
    }
}
