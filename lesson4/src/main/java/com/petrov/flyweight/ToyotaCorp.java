package com.petrov.flyweight;

//flyweight
import java.util.HashMap;
import java.util.Map;

public class ToyotaCorp {

    private Map<String, Toyota> cars = new HashMap<>();

    public void addCar(String model, String client){
        cars.put(client, new Toyota(model));
    }

    public Map<String, Toyota> getCars() {
        return cars;
    }
}
