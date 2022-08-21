package dev.patika.hgsproject.service;

import dev.patika.hgsproject.entities.vehicles.Vehicle;
import dev.patika.hgsproject.exception.AlreadyExistException;
import dev.patika.hgsproject.exception.NotFoundException;
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
        if(this.repository.findByHGSnumber(HGS_number)==null) throw new NotFoundException("a vehicle with HGS number "+HGS_number+" is NOT FOUND.");
        return this.repository.findByHGSnumber(HGS_number);
    }
    public void saveVehicle(Vehicle vehicle){
        repository.save(vehicle);
    }
    public void deleteVehicleByHGS_number(long HGS_number){
        if(repository.findByHGSnumber(HGS_number)==null) throw new NotFoundException("a vehicle with HGS number "+HGS_number+" is NOT FOUND.");
        else this.repository.deleteByHGSnumber(HGS_number);
    }
    public void saveVehicleTag(Vehicle vehicle){
        if (this.repository.findByHGSnumber(vehicle.getHGSnumber())!=null) throw new AlreadyExistException("a vehicle HGS tag with HGS number "+vehicle.getHGSnumber()+" already Exist.");
        else this.repository.save(vehicle);
    }
}

