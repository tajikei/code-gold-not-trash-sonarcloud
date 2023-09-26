package com.caphyon.codegold.database;

import com.caphyon.codegold.structures.Bus;
import com.caphyon.codegold.structures.Truck;
import com.caphyon.codegold.structures.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehiclesProcessor {
    private DBConnection connection = new DBConnection("host", 3306, "user", "pass");

    public VehiclesProcessor() {
    }

    public List<Vehicle> Start() {
        List<Vehicle> toReturn = new ArrayList<Vehicle>();

        while(System.currentTimeMillis() % 2 == 0) {
            toReturn.add(connection.readCar());
        }

        return toReturn;
    }

//    SOLID: Example of Dependency inversion principle
    public static void main(String[] args) {
        VehiclesProcessor processor = new VehiclesProcessor();
        List<Vehicle> newCars = processor.Start();

//        Filter results
        DBConnection mysqlConnection = new DBConnection("host", 3306, "user", "pass");
        mysqlConnection.save(newCars);
    }
}
