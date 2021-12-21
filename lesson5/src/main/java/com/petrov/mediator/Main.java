package com.petrov.mediator;
//mediator
public class Main {
    public static void main(String[] args) {
        Router router = new WiFiRouter();
        User tom = new User("Tom", router);
        User jerry = new User("Jerry", router);

        tom.sendMessage("Meow");
        jerry.sendMessage("Pi");
    }
}
