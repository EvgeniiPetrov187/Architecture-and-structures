package com.petrov.chainofresponsibility;

//chain of responsibility
public abstract class Car {
    private int speed;
    private Car car;

    public Car(int speed) {
        this.speed = speed;
    }

    public void setNext(Car car) {
        this.car = car;
    }

    public boolean canDriveWithSpeed(int maxSpeed) {
        return this.speed >= maxSpeed;
    }

    public void drive(int speed) {
        try {
            if (canDriveWithSpeed(speed)) {
                System.out.println("My speed is " + this.speed + " I'm the king of road");
            } else {
                this.car.drive(speed);
                System.out.println("My speed is " + this.speed + " I'm a turtle");
            }
        } catch (NullPointerException e) {
            System.out.println("My speed is " + this.speed + " I'm a turtle");
        }
    }
}
