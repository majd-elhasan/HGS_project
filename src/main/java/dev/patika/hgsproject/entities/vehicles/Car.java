package dev.patika.hgsproject.entities.vehicles;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle{
    public Car(long hgs_number, String fullName) {
        super(hgs_number, fullName, VehicleClass.car);
    }

    public Car() {

    }
}
