package com.petrov.observer;

//observer
import java.util.ArrayList;
import java.util.List;

public class PostOffice {

    private List<Receiver> receiverList = new ArrayList<>();

    public void notify(Post post) {
        for (Receiver receiver : receiverList) {
            receiver.getMessage(post);
        }
    }

    public void add(Receiver receiver) {
        receiverList.add(receiver);
    }

    public void addPost(Post post) {
        this.notify(post);
    }


}
