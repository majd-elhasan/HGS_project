package dev.patika.hgsproject.entities.vehicles;

import javax.persistence.Entity;

@Entity
public class Bus extends Vehicle{
    public Bus(long hgs_number, String fullName) {
        super(hgs_number, fullName, VehicleClass.bus);
    }

    public Bus() {

    }
}
