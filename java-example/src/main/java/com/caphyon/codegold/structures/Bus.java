package com.caphyon.codegold.structures;

public class Bus extends Vehicle {
    private int numberOfSeats;

    public Bus(String make, String model, int year, String engineType, float engineCapacity, int numberOfSeats) {
        super(make, model, year, engineType, engineCapacity);
        this.numberOfSeats = numberOfSeats;
    }

    //    SOLID: Interface segregation principle
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
