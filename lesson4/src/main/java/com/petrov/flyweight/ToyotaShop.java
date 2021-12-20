package com.petrov.flyweight;

//flyweight
import java.util.HashMap;
import java.util.Map;

public class ToyotaShop {
    private Map<String, Toyota> orders = new HashMap<>();
    private ToyotaCorp factory;

    public ToyotaShop(ToyotaCorp factory) {
        this.factory = factory;
    }

    public void takeOrder(String model, String client){
        factory.addCar(model, client);
        orders = factory.getCars();
    }

    public void deliver(){
        for (Map.Entry<String, Toyota> model: orders.entrySet()) {
            System.out.println("Deliver "+ model.getValue().getModel()+" to "+ model.getKey());
        }
    }
}
