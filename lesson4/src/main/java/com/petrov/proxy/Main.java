package com.petrov.proxy;

//proxy
public class Main {
    public static void main(String[] args) {

        Browser browser = new BrowserImpl();
        GoogleChrome googleChrome = new GoogleChrome(browser);

        googleChrome.start("ok google");
        googleChrome.stop();
    }
}
