package com.petrov.adapter;

//adapter
public class YamahaAdapter implements Car {

    private Yamaha yamaha;

    public YamahaAdapter(Yamaha yamaha) {
        this.yamaha = yamaha;
    }

    @Override
    public void wroom() {
        yamaha.wheee();
    }
}
