package dev.patika.hgsproject.service;

import dev.patika.hgsproject.entities.vehicles.Vehicle;
import dev.patika.hgsproject.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }
    public List<Vehicle> getAllVehicles() {
        return this.repository.findAll();
    }
    public Vehicle getVehicleByHGS_number(long HGS_number){
        return this.repository.findByHGSnumber(HGS_number);
    }
    public void saveVehicle(Vehicle vehicle){
        repository.save(vehicle);
    }
    public void deleteVehicleByHGS_number(long HGS_Number){
        this.repository.deleteByHGSnumber(HGS_Number);
    }
}

