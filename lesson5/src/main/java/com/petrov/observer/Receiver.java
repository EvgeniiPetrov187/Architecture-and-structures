package com.petrov.observer;

//observer
public class Receiver {
    private String name;

    public Receiver(String name) {
        this.name = name;
    }

    public void getMessage(Post post) {
        System.out.println("Mr. " + this.name + ", you have a letter: " + post.getLetter());
    }
}
