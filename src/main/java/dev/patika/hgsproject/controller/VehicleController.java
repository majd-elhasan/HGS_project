package dev.patika.hgsproject.controller;

import dev.patika.hgsproject.entities.vehicles.Vehicle;
import dev.patika.hgsproject.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    public ResponseEntity getVehicleByHGS_number(@PathVariable long HGS_Number){
        try {
            return ResponseEntity.ok( this.service.getVehicleByHGS_number(HGS_Number));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    @DeleteMapping
    public ResponseEntity<String> deleteVehicleByHGS_number(@RequestParam long HGS_number){
        try {
            this.service.deleteVehicleByHGS_number(HGS_number);
            return ResponseEntity.ok("the vehicle has been deleted successfully.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    @PostMapping
    @Transactional
    public ResponseEntity<String> saveVehicleTag(@RequestBody Vehicle vehicle){
       try {
           service.saveVehicleTag(vehicle);
           return ResponseEntity.ok("the vehicle HGS tag has been created successfully.");
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
       }
    }
}
