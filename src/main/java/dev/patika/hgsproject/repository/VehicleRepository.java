package dev.patika.hgsproject.repository;

import dev.patika.hgsproject.entities.vehicles.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    Vehicle findByHGSnumber(long HGS_number);
    void deleteByHGSnumber(long HGS_number);
}
