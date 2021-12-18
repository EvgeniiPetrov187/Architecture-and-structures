package com.petrov.proxy;

//proxy
public class BrowserImpl implements Browser{
    @Override
    public void start() {
        System.out.println("Open Browser");
    }

    @Override
    public void stop() {
        System.out.println("Close Browser");
    }
}
