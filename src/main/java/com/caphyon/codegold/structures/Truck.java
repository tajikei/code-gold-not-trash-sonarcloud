package com.caphyon.codegold.structures;

public class Truck extends Vehicle {
    private float trunkCapacity;

    public Truck(String make, String model, int year, String engineType, float engineCapacity, float trunkCapacity) {
        super(make, model, year, engineType, engineCapacity);
        this.trunkCapacity = trunkCapacity;
    }

    public float getTrunkCapacity() {
        return this.trunkCapacity;
    }

    public void setTrunkCapacity(float trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
    }
}
