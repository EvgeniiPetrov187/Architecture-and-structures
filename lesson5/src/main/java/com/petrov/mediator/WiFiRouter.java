package com.petrov.mediator;
//mediator
public class WiFiRouter implements Router {
    @Override
    public void sendMessage(User user, String message) {
        System.out.println(message + " to " + user.getName());
    }
}
