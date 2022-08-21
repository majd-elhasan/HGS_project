package dev.patika.hgsproject.controller;

import dev.patika.hgsproject.entities.Lane;
import dev.patika.hgsproject.exception.AlreadyExistException;
import dev.patika.hgsproject.exception.NotFoundException;
import dev.patika.hgsproject.service.LaneService;
import dev.patika.hgsproject.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/counters")
public class LaneController {
    private final LaneService laneService;
    private final VehicleService vehicleService;

    public LaneController(LaneService laneService, VehicleService vehicleService) {
        this.laneService = laneService;
        this.vehicleService = vehicleService;
    }
    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<Lane>> getAllCounters(){
        return ResponseEntity.ok(this.laneService.getAllCounters());
    }

    @PostMapping
    @Transactional
    public ResponseEntity saveLane(@RequestBody Lane lane){
        try {
            return ResponseEntity.ok(laneService.setLane(lane));
        }catch (Exception e){
            return (e instanceof AlreadyExistException)? ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage())
                    :(e instanceof NotFoundException)? ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage())
            : ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }

    }
    @DeleteMapping
    public ResponseEntity<String> deleteLane(@RequestBody Lane lane){
        try {
            this.laneService.deleteLane(lane);
            return ResponseEntity.ok("the counter has been deleted successfully.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    @PostMapping("getPayment/{counter_id}/{HGS_num}")
    @Transactional
    public ResponseEntity<String> getPayment(@PathVariable long counter_id, @PathVariable long HGS_num){
        try {
            this.laneService.payForToll(
                    laneService.findById(counter_id),vehicleService.getVehicleByHGS_number(HGS_num));
            return ResponseEntity.ok("the payment has been received successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
