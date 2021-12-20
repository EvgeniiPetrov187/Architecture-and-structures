package com.petrov.composite;

import java.util.ArrayList;
import java.util.List;

//composite
public class MyGarage {

    private List<Car> cars = new ArrayList();

    public void addCar(Car car){
        cars.add(car);
    }

    public void showMyCars(List<Car> cars){
        for (Car car: cars) {
            System.out.println(car.getName());
            System.out.println(car.getPower());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
