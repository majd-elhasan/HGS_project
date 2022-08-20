package dev.patika.hgsproject.entities.vehicles;

import javax.persistence.Entity;

@Entity
public class Minibus extends Vehicle {
    public Minibus(long hgs_number, String fullName) {
        super(hgs_number, fullName, VehicleClass.minibus);
    }

    public Minibus() {

    }
}