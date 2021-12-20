package com.petrov.proxy;

//proxy
public class GoogleChrome {

    private Browser browser;

    public GoogleChrome(Browser browser) {
        this.browser = browser;
    }

    public void start(String phrase) {
        if (listen(phrase)) {
            browser.start();
        }
    }

    private boolean listen(String phrase) {
        return phrase.equalsIgnoreCase("Ok Google");
    }

    public void stop() {
        browser.stop();
    }
}
