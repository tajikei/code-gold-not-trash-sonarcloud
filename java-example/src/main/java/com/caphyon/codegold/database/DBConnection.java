package com.caphyon.codegold.database;

import com.caphyon.codegold.structures.Bus;
import com.caphyon.codegold.structures.Car;
import com.caphyon.codegold.structures.Truck;
import com.caphyon.codegold.structures.Vehicle;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.concurrent.locks.Lock;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private String host;
    private int port;
    private String user;
    private String password;

    public DBConnection(String host, int port, String user, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;

        this.Connect();
    }

    public boolean Connect() {
        return true;
    }

    public void save(List<Vehicle> aVehicles) {
    }

    public void saveError() {
    }

    public Vehicle readCar() {
        return new Truck("Opel", "Astra", 2015, "Gasoline", 1600, 300);
    }

    public Vehicle getNewCars() {
        return new Truck("VW", "Polo", 2020, "Gasoline", 1200, 200);
    }

    public List<Vehicle> fetchCars() {
        List<Vehicle> toReturn = new ArrayList<Vehicle>();

        toReturn.add(new Truck("Opel", "Astra", 2015, "Gasoline", 1600, 300));
        toReturn.add(new Bus("Mercedes", "Truck", 2014, "Diesel", 3600, 50));
        toReturn.add(new Car("BMW", "i8", 2019, "Electric", 1600, new ArrayList<String>()));
        toReturn.add(new Truck("Audi", "A4", 2020, "Gasoline", 2000, 350));

        return toReturn;
    }

    public String GetProperty() {
        return "";
    }
}
