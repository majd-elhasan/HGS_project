package dev.patika.hgsproject.controller;

import dev.patika.hgsproject.entities.vehicles.Vehicle;
import dev.patika.hgsproject.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        return ResponseEntity.ok( this.service.getAllVehicles());
    }

    @GetMapping("/{HGS_Number}")
    public ResponseEntity<Vehicle> getVehicleByHGS_number(@PathVariable long HGS_Number){
        return ResponseEntity.ok( this.service.getVehicleByHGS_number(HGS_Number));
    }
    @DeleteMapping
    public ResponseEntity<String> deleteVehicleByHGS_number(@RequestParam long HGS_number){
        this.service.deleteVehicleByHGS_number(HGS_number);
        return ResponseEntity.ok("the vehicle has been deleted successfully.");
    }
}
