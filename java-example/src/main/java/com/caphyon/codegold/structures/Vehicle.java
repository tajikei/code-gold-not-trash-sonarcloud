package com.caphyon.codegold.structures;

public class Vehicle {
    private String make;
    private String model;

//    Example of bad practices
    private int yearwhenthecarwasmade;
    private int fyear;
    private int f_year; // Year when the car was made
    private int f_y;

//    Example of good practices
    private int fabricationYear;
    private int year;

    private String engine_type;
    private float engineCapacity;

    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Vehicle(String make, String model, int year, String engine_type, float engineCapacity) {
        this.make = make;
        this.model = model;
        this.f_year = year;
        this.engine_type = engine_type;
        this.engineCapacity = engineCapacity;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

//    returns the fabrication year
    public int getF_year() {
        return f_year;
    }

    public void setF_year(int f_year) {
        this.f_year = f_year;
    }

    public String getEngine_type() {
        return engine_type;
    }

    public void setEngine_type(String engine_type) {
        this.engine_type = engine_type;
    }

//    Never write code in different languages
    public float getCapacitateMotor() {
        return engineCapacity;
    }

    public void setEngineCapacity(float engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

//    SOLID: Example of Open/closed principle
    public boolean isCar() {
        if(this instanceof Car || this instanceof Van) {
            return true;
        }

        return false;
    }

    public void start() {
//        TODO: Add code that starts the vehicle
//        Step 1: Press the brake for automatic transmision or the clutch for manual
//        Step 2: Rotate the key to position 2
//        Step 3: Wait 2 seconds
//        Step 4: Rotate the key to position 3
    }

    public static class Builder {
        private String make;
        private String model;

        private int fabricationYear;
        private String engineType;

        public Builder(String make, String model) {
            this.make = make;
            this.model = model;
        }

        private float engineCapacity;

        public Builder withFabricationYear(int aFabricationYear) {
            this.fabricationYear =  aFabricationYear;
            return this;
        }

        public Builder withEngineType(String aEngineType) {
            this.engineType =  engineType;
            return this;
        }

        public Builder withEngineCapacity(int aEngineCapacity) {
            this.engineCapacity =  engineCapacity;
            return this;
        }


        public Vehicle build() {
            Vehicle toReturn = new Vehicle(this.make, this.model);
            toReturn.setF_year(this.fabricationYear);
            toReturn.setEngine_type(this.engineType);
            toReturn.setEngineCapacity(this.engineCapacity);

            return toReturn;
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Tesla", "CyberTruck", 2020, "Electric", 1400);

        Vehicle v2 = new Vehicle.Builder("Tesla", "CuberTruck")
                .withFabricationYear(2020)
                .withEngineType("Electric")
                .withEngineCapacity(1400).build();

        //    SOLID: Liskov substitution principle
        if(v1 instanceof Car)
            v1.start();
        else if (v1 instanceof Motorcycle)
            ((Motorcycle) v1).startMotorcycle();

    }
}
