package com.petrov.mediator;
//mediator
public class User {
    private String name;
    private Router router;

    public User(String name, Router router) {
        this.name = name;
        this.router = router;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message){
        this.router.sendMessage(this, message);
    }
}
