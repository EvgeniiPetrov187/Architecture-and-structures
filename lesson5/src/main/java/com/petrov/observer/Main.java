package com.petrov.observer;

//observer
public class Main {
    public static void main(String[] args) {

        Receiver john = new Receiver("Holmes");
        Receiver nakamichi = new Receiver("Watson");

        PostOffice postOffice = new PostOffice();
        postOffice.add(john);
        postOffice.add(nakamichi);

        postOffice.addPost(new Post("Hello from Moriarty!"));
    }
}
