package dev.patika.hgsproject.entities.vehicles;

import javax.persistence.*;

@Entity
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    // 10 digits
    @Column(name = "hgs_number")
    public long HGSnumber;
    String fullName;
    VehicleClass vehicleClass;
    public double balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    Vehicle(long hgs_number, String fullName, VehicleClass vehicleClass){
        this.HGSnumber =hgs_number;
        this.fullName = fullName;
        this.vehicleClass = vehicleClass;
    }

    public Vehicle() {

    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "HGS_number=" + HGSnumber +
                ", fullName='" + fullName + '\'' +
                ", vehicleClass=" + vehicleClass +
                ", balance=" + balance +
                '}';
    }

    public enum VehicleClass {
        none,car,minibus,bus
    }
}
