package com.petrov.flyweight;

//flyweight
public class Main {
    public static void main(String[] args) {

        ToyotaCorp factory = new ToyotaCorp();
        ToyotaShop shop = new ToyotaShop(factory);

        shop.takeOrder("Corolla", "Mr. Takashi");
        shop.takeOrder("Supra", "Mr. Kenji");
        shop.takeOrder("Rav4", "Mr. Takeda");

        shop.deliver();

    }
}
