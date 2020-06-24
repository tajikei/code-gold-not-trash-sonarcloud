package com.caphyon.codegold.structures;

public class Van extends Vehicle {
    private int numberOfSeats;

    public Van(String make, String model, int year, String engineType, float engineCapacity, int numberOfSeats) {
        super(make, model, year, engineType, engineCapacity);
        this.numberOfSeats = numberOfSeats;
    }

    //    SOLID: Interface segregation principle: Create a new interface for PersonCarrier
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
