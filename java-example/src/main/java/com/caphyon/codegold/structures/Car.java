package com.caphyon.codegold.structures;

import java.util.List;

public class Car extends Vehicle {
    public Car(String make, String model, int year, String engineType, float engineCapacity, List<String> options) {
        super(make, model, year, engineType, engineCapacity);
        this.options = options;
    }

    private List<String> options;

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
