package dev.patika.hgsproject.entities.vehicles;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // 10 digits
    @Column(name = "hgs_number")
    private long HGSnumber;
    private String driverFullName;
    private VehicleClass vehicleClass;
    private double balance;

    Vehicle(long hgs_number, String driverFullName, VehicleClass vehicleClass){
        this.HGSnumber =hgs_number;
        this.driverFullName = driverFullName;
        this.vehicleClass = vehicleClass;
    }

    public Vehicle() {

    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "HGS_number=" + HGSnumber +
                ", fullName='" + driverFullName + '\'' +
                ", vehicleClass=" + vehicleClass +
                ", balance=" + balance +
                '}';
    }

    public enum VehicleClass {
        none,car,minibus,bus
    }
}
