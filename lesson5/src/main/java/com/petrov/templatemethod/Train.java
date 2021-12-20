package com.petrov.templatemethod;
//template method
public class Train extends Transport{

    public void buyTicket(){
        System.out.println("Two tickets please");
    }
    public void travel(){
        System.out.println("Tuk-tuk");
    }

}
